package com.liao.system.services.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.constant.Constants;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.exception.user.LoginException;
import com.liao.commons.exception.user.PermissionException;
import com.liao.commons.sytstem.entity.SysMenu;
import com.liao.commons.utils.RedisUtil;
import com.liao.commons.utils.StringUtils;
import com.liao.commons.utils.TokenUtil;
import com.liao.framework.manager.AsyncManager;
import com.liao.framework.manager.factory.AsyncFactory;
import com.liao.system.dao.SysUserMapper;
import com.liao.system.entity.SysAdmin;
import com.liao.system.entity.SysRole;
import com.liao.system.entity.SysUser;
import com.liao.system.entity.vo.RouterVo;
import com.liao.system.services.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2020-12-31
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    // Redis 操作
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 普通用户登录
     *
     * @param account  账号
     * @param password 密码
     * @return 返回值
     */
    @Override
    public R login(String account, String password) {

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_account", account)
                .eq("user_password", password);

        List<SysUser> sysAdminIPage = sysUserMapper.selectPage(PageUtils.startDefPage(), wrapper).getRecords();

        // 登录校验
        if (StringUtils.isEmpty(sysAdminIPage)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(password, Constants.LOGIN_FAIL, "账号密码错误"));
            throw new LoginException();
        }

        Map<String, String> map = new HashMap<>();

        Long userId = sysAdminIPage.get(0).getUserId();

        // userJsonStr
        String userJsonStr = JSON.toJSONString(sysAdminIPage.get(0));

        map.put("user", userJsonStr);

        // 生成Token
        String token = TokenUtil.token(map);

        // 生成唯一Redis-key
        String redisKey = "user-" + userId;

        // 入库
        redisUtil.set(redisKey, token, Constants.EXPIRE_DATE);

        AsyncManager.me().execute(AsyncFactory.recordLogininfor(account, Constants.LOGIN_SUCCESS, "登录成功"));

        return R.success(redisKey, map);
    }

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysUser recode) {
        // 分页信息
        IPage<SysUser> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

        // 用户主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserId()), "user_id", recode.getUserId());
        // 用户账户SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserAccount()), "user_account", recode.getUserAccount());
        // 用户密码SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserPassword()), "user_password", recode.getUserPassword());
        // 用户姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserName()), "user_name", recode.getUserName());
        // 性别SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserSex()), "user_sex", recode.getUserSex());
        // 昵称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserNickname()), "user_nickname", recode.getUserNickname());
        // 头像SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserAvatar()), "user_avatar", recode.getUserAvatar());
        // 邮箱SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserEmail()), "user_email", recode.getUserEmail());
        // 手机号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserPhon()), "user_phon", recode.getUserPhon());
        // 是否密保SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserProtection()), "user_protection", recode.getUserProtection());
        // 是否实名认证SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserCertification()), "user_certification", recode.getUserCertification());
        // 备注SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUserRemarks()), "user_remarks", recode.getUserRemarks());
        // 登录时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLoginTime()), "login_time", recode.getLoginTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<SysUser> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysUserMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id) {
        return R.r(sysUserMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids) {
        return R.r(sysUserMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysUser recode) {
        return R.r(sysUserMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysUser recode) {
        if (StringUtils.isEmpty(recode.getUserId())) {
            throw new MissingParametersException("用户表ID");
        }
        return R.r(sysUserMapper.updateById(recode));
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R delete(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new MissingParametersException("用户表ID");
        }
        return R.r(sysUserMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids) {
        return R.r(sysUserMapper.deleteBatchIds(ids));
    }
}

package com.liao.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.system.dao.SysRealNameMapper;
import com.liao.system.entity.SysRealName;
import com.liao.system.services.SysRealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户实名认证信息 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class SysRealNameServiceImpl extends ServiceImpl<SysRealNameMapper, SysRealName> implements SysRealNameService {

    @Autowired
    private SysRealNameMapper sysRealNameMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysRealName recode) {
        // 分页信息
        IPage<SysRealName> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysRealName> queryWrapper = new QueryWrapper<>();

        // 实名认证idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRnId()), "rn_id", recode.getRnId());
        // 用户idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRnUId()), "rn_u_id", recode.getRnUId());
        // 姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRnName()), "rn_name", recode.getRnName());
        // 性别SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRnSex()), "rn_sex", recode.getRnSex());
        // 出生日期SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmBornDate()), "rm_born_date", recode.getRmBornDate());
        // 身份证号码SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmIdCard()), "rm_id_card", recode.getRmIdCard());
        // 身份证正面SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmPositive()), "rm_positive", recode.getRmPositive());
        // 身份证反面SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmNegative()), "rm_negative", recode.getRmNegative());
        // 签发机构SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmMechanism()), "rm_mechanism", recode.getRmMechanism());
        // 签发日期SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmIssueDate()), "rm_Issue_date", recode.getRmIssueDate());
        // 到期时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRmMaturityDate()), "rm_maturity_date", recode.getRmMaturityDate());
        // 乐观锁SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVsersion()), "vsersion", recode.getVsersion());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<SysRealName> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysRealNameMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysRealNameMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysRealNameMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysRealName recode) {
        return R.r(sysRealNameMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysRealName recode) {
        if (StringUtils.isEmpty(recode.getRnId())) {
            throw new MissingParametersException("用户实名认证信息ID");
        }
        return R.r(sysRealNameMapper.updateById(recode));
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R delete(Long id){
        if (StringUtils.isEmpty(id)) {
            throw new MissingParametersException("用户实名认证信息ID");
        }
        return R.r(sysRealNameMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysRealNameMapper.deleteBatchIds(ids));
    }
}

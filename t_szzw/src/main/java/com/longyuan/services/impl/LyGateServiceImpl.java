package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.LyGateMapper;
import com.longyuan.entity.LyGate;
import com.longyuan.services.LyGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 网关表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Service
public class LyGateServiceImpl extends ServiceImpl<LyGateMapper, LyGate> implements LyGateService {

    @Autowired
    private LyGateMapper lyGateMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(LyGate recode) {
        // 分页信息
        IPage<LyGate> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<LyGate> queryWrapper = new QueryWrapper<>();

        //  idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGId()), "g_id", recode.getGId());
        // 用户idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGUserId()), "g_user_id", recode.getGUserId());
        // 网关idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGGateId()), "g_gate_id", recode.getGGateId());
        // 网关名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGName()), "g_name", recode.getGName());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 更新时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<LyGate> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(lyGateMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(lyGateMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(lyGateMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(LyGate recode) {
        return R.r(lyGateMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(LyGate recode) {
        if (StringUtils.isEmpty(recode.getGId())) {
            throw new MissingParametersException("网关表ID");
        }
        return R.r(lyGateMapper.updateById(recode));
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
            throw new MissingParametersException("网关表ID");
        }
        return R.r(lyGateMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(lyGateMapper.deleteBatchIds(ids));
    }
}

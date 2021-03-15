package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.PerceiveMapper;
import com.longyuan.entity.Perceive;
import com.longyuan.services.PerceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Service
public class PerceiveServiceImpl extends ServiceImpl<PerceiveMapper, Perceive> implements PerceiveService {

    @Autowired
    private PerceiveMapper perceiveMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(Perceive recode) {
        // 分页信息
        IPage<Perceive> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<Perceive> queryWrapper = new QueryWrapper<>();

        // idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPId()), "p_id", recode.getPId());
        // 网关SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPGate()), "p_gate", recode.getPGate());
        // 片区编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPArea()), "p_area", recode.getPArea());
        // 设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPName()), "p_name", recode.getPName());
        // 设备编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPDeviceId()), "p_device_id", recode.getPDeviceId());
        // 离散变量 非离散变量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPOp()), "p_op", recode.getPOp());
        // 变量数值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPValue()), "p_value", recode.getPValue());
        // 单位SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPUnit()), "p_unit", recode.getPUnit());
        // 设备类型 0：传感器 2：控制设备SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPType()), "p_type", recode.getPType());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 更新时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<Perceive> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(perceiveMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(perceiveMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(perceiveMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(Perceive recode) {
        return R.r(perceiveMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(Perceive recode) {
        if (StringUtils.isEmpty(recode.getPId())) {
            throw new MissingParametersException("ID");
        }
        return R.r(perceiveMapper.updateById(recode));
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
            throw new MissingParametersException("ID");
        }
        return R.r(perceiveMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(perceiveMapper.deleteBatchIds(ids));
    }
}

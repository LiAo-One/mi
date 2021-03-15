package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.LyTaskRecordMapper;
import com.longyuan.entity.LyTaskRecord;
import com.longyuan.services.LyTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务执行记录表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Service
public class LyTaskRecordServiceImpl extends ServiceImpl<LyTaskRecordMapper, LyTaskRecord> implements LyTaskRecordService {

    @Autowired
    private LyTaskRecordMapper lyTaskRecordMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(LyTaskRecord recode) {
        // 分页信息
        IPage<LyTaskRecord> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<LyTaskRecord> queryWrapper = new QueryWrapper<>();

        // 任务执行记录idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTrId()), "tr_id", recode.getTrId());
        // 业务类型（0 数据更新 1手动控制 2 阈值任务）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBusinessType()), "business_type", recode.getBusinessType());
        // 网关编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGateId()), "gate_id", recode.getGateId());
        // 片区编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRegId()), "reg_id", recode.getRegId());
        // 设备idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPerceiveId()), "perceive_id", recode.getPerceiveId());
        // 设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPerceiveName()), "perceive_name", recode.getPerceiveName());
        // 设备类型（0 传感器 2控制设备）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPerceiveType()), "perceive_type", recode.getPerceiveType());
        // 执行的值（控制设备：0关闭 1开，传感器：当时采集的数据）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPerceiveValue()), "perceive_value", recode.getPerceiveValue());
        // 设备状态 （0 在线 1 离线）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPerceiveStatus()), "perceive_status", recode.getPerceiveStatus());
        // 操作状态 0成功 1失败SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStatus()), "status", recode.getStatus());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<LyTaskRecord> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(lyTaskRecordMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(lyTaskRecordMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(lyTaskRecordMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(LyTaskRecord recode) {
        return R.r(lyTaskRecordMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(LyTaskRecord recode) {
        if (StringUtils.isEmpty(recode.getTrId())) {
            throw new MissingParametersException("任务执行记录表ID");
        }
        return R.r(lyTaskRecordMapper.updateById(recode));
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
            throw new MissingParametersException("任务执行记录表ID");
        }
        return R.r(lyTaskRecordMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(lyTaskRecordMapper.deleteBatchIds(ids));
    }
}

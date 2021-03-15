package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwIntdymonitoringMapper;
import com.longyuan.entity.SzzwIntdymonitoring;
import com.longyuan.services.SzzwIntdymonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 智慧动监表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwIntdymonitoringServiceImpl extends ServiceImpl<SzzwIntdymonitoringMapper, SzzwIntdymonitoring> implements SzzwIntdymonitoringService {

    @Autowired
    private SzzwIntdymonitoringMapper szzwIntdymonitoringMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwIntdymonitoring recode) {
        // 分页信息
        IPage<SzzwIntdymonitoring> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwIntdymonitoring> queryWrapper = new QueryWrapper<>();

        // 智慧动监主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMonitoringId()), "monitoring_id", recode.getMonitoringId());
        // 地图地标名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMapname()), "mapname", recode.getMapname());
        // 详细地址SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDesaddress()), "desaddress", recode.getDesaddress());
        // 检查站介绍SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getInsstation()), "insstation", recode.getInsstation());
        // 经度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLongitude()), "longitude", recode.getLongitude());
        // 纬度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLatitude()), "latitude", recode.getLatitude());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 自动更新时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwIntdymonitoring> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwIntdymonitoringMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwIntdymonitoringMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwIntdymonitoringMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwIntdymonitoring recode) {
        return R.r(szzwIntdymonitoringMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwIntdymonitoring recode) {
        if (StringUtils.isEmpty(recode.getMonitoringId())) {
            throw new MissingParametersException("智慧动监表ID");
        }
        return R.r(szzwIntdymonitoringMapper.updateById(recode));
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
            throw new MissingParametersException("智慧动监表ID");
        }
        return R.r(szzwIntdymonitoringMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwIntdymonitoringMapper.deleteBatchIds(ids));
    }
}

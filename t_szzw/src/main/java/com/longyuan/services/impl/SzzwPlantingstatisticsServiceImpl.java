package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwPlantingstatisticsMapper;
import com.longyuan.entity.SzzwPlantingstatistics;
import com.longyuan.services.SzzwPlantingstatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 种植科统计 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwPlantingstatisticsServiceImpl extends ServiceImpl<SzzwPlantingstatisticsMapper, SzzwPlantingstatistics> implements SzzwPlantingstatisticsService {

    @Autowired
    private SzzwPlantingstatisticsMapper szzwPlantingstatisticsMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwPlantingstatistics recode) {
        // 分页信息
        IPage<SzzwPlantingstatistics> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwPlantingstatistics> queryWrapper = new QueryWrapper<>();

        // 主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingstatisticsId()), "plantingstatistics_id", recode.getPlantingstatisticsId());
        // 统计名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingstatisticsStatisticalname()), "plantingstatistics_statisticalname", recode.getPlantingstatisticsStatisticalname());
        // 统计数值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingstatisticsStatistics()), "plantingstatistics_statistics", recode.getPlantingstatisticsStatistics());
        // 统计单位SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingstatisticsStatisticalunit()), "plantingstatistics_statisticalunit", recode.getPlantingstatisticsStatisticalunit());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwPlantingstatistics> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwPlantingstatisticsMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwPlantingstatisticsMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwPlantingstatisticsMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwPlantingstatistics recode) {
        return R.r(szzwPlantingstatisticsMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwPlantingstatistics recode) {
        if (StringUtils.isEmpty(recode.getPlantingstatisticsId())) {
            throw new MissingParametersException("种植科统计ID");
        }
        return R.r(szzwPlantingstatisticsMapper.updateById(recode));
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
            throw new MissingParametersException("种植科统计ID");
        }
        return R.r(szzwPlantingstatisticsMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwPlantingstatisticsMapper.deleteBatchIds(ids));
    }
}

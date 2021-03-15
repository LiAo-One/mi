package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwInfostatisticsMapper;
import com.longyuan.entity.SzzwInfostatistics;
import com.longyuan.services.SzzwInfostatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 信息入户统计表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwInfostatisticsServiceImpl extends ServiceImpl<SzzwInfostatisticsMapper, SzzwInfostatistics> implements SzzwInfostatisticsService {

    @Autowired
    private SzzwInfostatisticsMapper szzwInfostatisticsMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwInfostatistics recode) {
        // 分页信息
        IPage<SzzwInfostatistics> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwInfostatistics> queryWrapper = new QueryWrapper<>();

        // 信息入户统计主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStatisticsId()), "statistics_id", recode.getStatisticsId());
        // 统计名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStatisticsname()), "statisticsname", recode.getStatisticsname());
        // 统计数值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStatisticsnum()), "statisticsnum", recode.getStatisticsnum());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 自动更新时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwInfostatistics> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwInfostatisticsMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwInfostatisticsMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwInfostatisticsMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwInfostatistics recode) {
        return R.r(szzwInfostatisticsMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwInfostatistics recode) {
        if (StringUtils.isEmpty(recode.getStatisticsId())) {
            throw new MissingParametersException("信息入户统计表ID");
        }
        return R.r(szzwInfostatisticsMapper.updateById(recode));
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
            throw new MissingParametersException("信息入户统计表ID");
        }
        return R.r(szzwInfostatisticsMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwInfostatisticsMapper.deleteBatchIds(ids));
    }
}

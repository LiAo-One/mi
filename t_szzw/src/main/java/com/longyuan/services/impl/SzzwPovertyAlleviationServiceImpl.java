package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwPovertyAlleviationMapper;
import com.longyuan.entity.SzzwPovertyAlleviation;
import com.longyuan.services.SzzwPovertyAlleviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 扶贫与社会事业 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwPovertyAlleviationServiceImpl extends ServiceImpl<SzzwPovertyAlleviationMapper, SzzwPovertyAlleviation> implements SzzwPovertyAlleviationService {

    @Autowired
    private SzzwPovertyAlleviationMapper szzwPovertyAlleviationMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwPovertyAlleviation recode) {
        // 分页信息
        IPage<SzzwPovertyAlleviation> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwPovertyAlleviation> queryWrapper = new QueryWrapper<>();

        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAlleviationId()), "alleviation_id", recode.getAlleviationId());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRegionName()), "region_name", recode.getRegionName());
        // 农业保险费用SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAgriInsureTotal()), "agri_insure_total", recode.getAgriInsureTotal());
        // 高效农业保险（万元）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getEfficAgri()), "effic_agri", recode.getEfficAgri());
        // 主要种植保护（万元）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMainPlantAgri()), "main_plant_agri", recode.getMainPlantAgri());
        // 高效农业保费占农业保险保费总额比重(%)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDfficAgriProportion()), "dffic_agri_proportion", recode.getDfficAgriProportion());
        // 三大主粮作物承保面积(万亩)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getThreeMainGrainPlantProportion()), "three_main_grain_plant_proportion", recode.getThreeMainGrainPlantProportion());
        // 三大主粮作物承保面积(万亩)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getThreeMainGrainContractProportion()), "three_main_grain_contract_proportion", recode.getThreeMainGrainContractProportion());
        //  经度(万亩)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRegionJing()), "region_jing", recode.getRegionJing());
        // 纬度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRegionWei()), "region_wei", recode.getRegionWei());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCurrentTimestamp()), "current_timestamp", recode.getCurrentTimestamp());

        // 排序信息
        QueryWrapper<SzzwPovertyAlleviation> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwPovertyAlleviationMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwPovertyAlleviationMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwPovertyAlleviationMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwPovertyAlleviation recode) {
        return R.r(szzwPovertyAlleviationMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwPovertyAlleviation recode) {
        if (StringUtils.isEmpty(recode.getAlleviationId())) {
            throw new MissingParametersException("扶贫与社会事业ID");
        }
        return R.r(szzwPovertyAlleviationMapper.updateById(recode));
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
            throw new MissingParametersException("扶贫与社会事业ID");
        }
        return R.r(szzwPovertyAlleviationMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwPovertyAlleviationMapper.deleteBatchIds(ids));
    }
}

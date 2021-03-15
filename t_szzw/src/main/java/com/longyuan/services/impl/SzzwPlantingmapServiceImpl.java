package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwPlantingmapMapper;
import com.longyuan.entity.SzzwPlantingmap;
import com.longyuan.services.SzzwPlantingmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 种植科（地图地区展示） 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwPlantingmapServiceImpl extends ServiceImpl<SzzwPlantingmapMapper, SzzwPlantingmap> implements SzzwPlantingmapService {

    @Autowired
    private SzzwPlantingmapMapper szzwPlantingmapMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwPlantingmap recode) {
        // 分页信息
        IPage<SzzwPlantingmap> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwPlantingmap> queryWrapper = new QueryWrapper<>();

        // 主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingmapId()), "plantingmap_id", recode.getPlantingmapId());
        // 地标名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingmapNameoflandmark()), "plantingmap_nameoflandmark", recode.getPlantingmapNameoflandmark());
        // 地标子维度1SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingmapLandmarksubone()), "plantingmap_landmarksubone", recode.getPlantingmapLandmarksubone());
        // 地标子维度2SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingmapLandmarksubtwo()), "plantingmap_landmarksubtwo", recode.getPlantingmapLandmarksubtwo());
        // 地标子维度3SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingmapLandmarksubthree()), "plantingmap_landmarksubthree", recode.getPlantingmapLandmarksubthree());
        // 地标子维度4SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlantingmapLandmarksubfour()), "plantingmap_landmarksubfour", recode.getPlantingmapLandmarksubfour());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwPlantingmap> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwPlantingmapMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwPlantingmapMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwPlantingmapMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwPlantingmap recode) {
        return R.r(szzwPlantingmapMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwPlantingmap recode) {
        if (StringUtils.isEmpty(recode.getPlantingmapId())) {
            throw new MissingParametersException("种植科（地图地区展示）ID");
        }
        return R.r(szzwPlantingmapMapper.updateById(recode));
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
            throw new MissingParametersException("种植科（地图地区展示）ID");
        }
        return R.r(szzwPlantingmapMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwPlantingmapMapper.deleteBatchIds(ids));
    }
}

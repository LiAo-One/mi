package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwTillCropMapper;
import com.longyuan.entity.SzzwTillCrop;
import com.longyuan.services.SzzwTillCropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 耕地保护 农作物种植情况 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwTillCropServiceImpl extends ServiceImpl<SzzwTillCropMapper, SzzwTillCrop> implements SzzwTillCropService {

    @Autowired
    private SzzwTillCropMapper szzwTillCropMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwTillCrop recode) {
        // 分页信息
        IPage<SzzwTillCrop> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwTillCrop> queryWrapper = new QueryWrapper<>();

        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCropId()), "crop_id", recode.getCropId());
        // 户主编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHouseholdNum()), "household_num", recode.getHouseholdNum());
        // 作物种类SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCropType()), "crop_type", recode.getCropType());
        // 作物面积SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCropArea()), "crop_area", recode.getCropArea());
        // 施药器材种类SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDrugEquiType()), "drug_equi_type", recode.getDrugEquiType());
        // 用药次数SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUseDrugNum()), "use_drug_num", recode.getUseDrugNum());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCurrentTimestamp()), "current_timestamp", recode.getCurrentTimestamp());

        // 排序信息
        QueryWrapper<SzzwTillCrop> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwTillCropMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwTillCropMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwTillCropMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwTillCrop recode) {
        return R.r(szzwTillCropMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwTillCrop recode) {
        if (StringUtils.isEmpty(recode.getCropId())) {
            throw new MissingParametersException("耕地保护 农作物种植情况ID");
        }
        return R.r(szzwTillCropMapper.updateById(recode));
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
            throw new MissingParametersException("耕地保护 农作物种植情况ID");
        }
        return R.r(szzwTillCropMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwTillCropMapper.deleteBatchIds(ids));
    }
}

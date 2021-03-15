package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwQualityMapper;
import com.longyuan.entity.SzzwQuality;
import com.longyuan.services.SzzwQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 质量安全表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwQualityServiceImpl extends ServiceImpl<SzzwQualityMapper, SzzwQuality> implements SzzwQualityService {

    @Autowired
    private SzzwQualityMapper szzwQualityMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwQuality recode) {
        // 分页信息
        IPage<SzzwQuality> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwQuality> queryWrapper = new QueryWrapper<>();

        // 质量安全主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getQualityId()), "quality_id", recode.getQualityId());
        // 镇名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTown()), "town", recode.getTown());
        // 基地名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBasename()), "basename", recode.getBasename());
        // 地点SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlace()), "place", recode.getPlace());
        // 经度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLongitude()), "longitude", recode.getLongitude());
        // 纬度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLatitude()), "latitude", recode.getLatitude());
        // 联系人姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactname()), "contactname", recode.getContactname());
        // 联系人电话SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTelephone()), "telephone", recode.getTelephone());
        // 备注SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRemarks()), "remarks", recode.getRemarks());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 自动更新时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwQuality> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwQualityMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwQualityMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwQualityMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwQuality recode) {
        return R.r(szzwQualityMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwQuality recode) {
        if (StringUtils.isEmpty(recode.getQualityId())) {
            throw new MissingParametersException("质量安全表ID");
        }
        return R.r(szzwQualityMapper.updateById(recode));
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
            throw new MissingParametersException("质量安全表ID");
        }
        return R.r(szzwQualityMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwQualityMapper.deleteBatchIds(ids));
    }
}

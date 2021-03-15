package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwMapdisplayMapper;
import com.longyuan.entity.SzzwMapdisplay;
import com.longyuan.services.SzzwMapdisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 信息入户(地图地区展示)表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwMapdisplayServiceImpl extends ServiceImpl<SzzwMapdisplayMapper, SzzwMapdisplay> implements SzzwMapdisplayService {

    @Autowired
    private SzzwMapdisplayMapper szzwMapdisplayMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwMapdisplay recode) {
        // 分页信息
        IPage<SzzwMapdisplay> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwMapdisplay> queryWrapper = new QueryWrapper<>();

        // 信息入户(地图地区展示)主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMapdisplayId()), "mapdisplay_id", recode.getMapdisplayId());
        // 地区名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDistrictname()), "districtname", recode.getDistrictname());
        // 经度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMapLongitude()), "map_longitude", recode.getMapLongitude());
        // 纬度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMapLatitude()), "map_latitude", recode.getMapLatitude());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 自动更新时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwMapdisplay> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwMapdisplayMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwMapdisplayMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwMapdisplayMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwMapdisplay recode) {
        return R.r(szzwMapdisplayMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwMapdisplay recode) {
        if (StringUtils.isEmpty(recode.getMapdisplayId())) {
            throw new MissingParametersException("信息入户(地图地区展示)表ID");
        }
        return R.r(szzwMapdisplayMapper.updateById(recode));
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
            throw new MissingParametersException("信息入户(地图地区展示)表ID");
        }
        return R.r(szzwMapdisplayMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwMapdisplayMapper.deleteBatchIds(ids));
    }
}

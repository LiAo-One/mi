package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwBreedmapMapper;
import com.longyuan.entity.SzzwBreedmap;
import com.longyuan.services.SzzwBreedmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 养殖科(地图地区展示)表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwBreedmapServiceImpl extends ServiceImpl<SzzwBreedmapMapper, SzzwBreedmap> implements SzzwBreedmapService {

    @Autowired
    private SzzwBreedmapMapper szzwBreedmapMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwBreedmap recode) {
        // 分页信息
        IPage<SzzwBreedmap> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwBreedmap> queryWrapper = new QueryWrapper<>();

        // 养殖科地图地区展示主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBreedmapId()), "breedmap_id", recode.getBreedmapId());
        // 产业地标名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getName()), "name", recode.getName());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 自动更新时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwBreedmap> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwBreedmapMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwBreedmapMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwBreedmapMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwBreedmap recode) {
        return R.r(szzwBreedmapMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwBreedmap recode) {
        if (StringUtils.isEmpty(recode.getBreedmapId())) {
            throw new MissingParametersException("养殖科(地图地区展示)表ID");
        }
        return R.r(szzwBreedmapMapper.updateById(recode));
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
            throw new MissingParametersException("养殖科(地图地区展示)表ID");
        }
        return R.r(szzwBreedmapMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwBreedmapMapper.deleteBatchIds(ids));
    }
}

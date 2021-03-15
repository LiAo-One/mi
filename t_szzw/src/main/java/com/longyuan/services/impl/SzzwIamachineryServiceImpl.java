package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwIamachineryMapper;
import com.longyuan.entity.SzzwIamachinery;
import com.longyuan.services.SzzwIamachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 智慧农机表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwIamachineryServiceImpl extends ServiceImpl<SzzwIamachineryMapper, SzzwIamachinery> implements SzzwIamachineryService {

    @Autowired
    private SzzwIamachineryMapper szzwIamachineryMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwIamachinery recode) {
        // 分页信息
        IPage<SzzwIamachinery> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwIamachinery> queryWrapper = new QueryWrapper<>();

        // 智慧农机主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAgriculturalId()), "agricultural_id", recode.getAgriculturalId());
        // 镇，街道SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTown()), "town", recode.getTown());
        // 动力机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPowmachinery()), "powmachinery", recode.getPowmachinery());
        // 耕整地机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLpmachinery()), "lpmachinery", recode.getLpmachinery());
        // 种植机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlmachinery()), "plmachinery", recode.getPlmachinery());
        // 植保机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlpromachinery()), "plpromachinery", recode.getPlpromachinery());
        // 收获机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHarvester()), "harvester", recode.getHarvester());
        // 收获后处理机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPhartrmachinery()), "phartrmachinery", recode.getPhartrmachinery());
        // 秸秆处理机械SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getSpromachinery()), "spromachinery", recode.getSpromachinery());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 自动更新时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwIamachinery> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwIamachineryMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwIamachineryMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwIamachineryMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwIamachinery recode) {
        return R.r(szzwIamachineryMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwIamachinery recode) {
        if (StringUtils.isEmpty(recode.getAgriculturalId())) {
            throw new MissingParametersException("智慧农机表ID");
        }
        return R.r(szzwIamachineryMapper.updateById(recode));
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
            throw new MissingParametersException("智慧农机表ID");
        }
        return R.r(szzwIamachineryMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwIamachineryMapper.deleteBatchIds(ids));
    }
}

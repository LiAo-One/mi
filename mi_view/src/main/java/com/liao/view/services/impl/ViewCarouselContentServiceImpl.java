package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewCarouselContentMapper;
import com.liao.view.entity.ViewCarouselContent;
import com.liao.view.services.ViewCarouselContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图内容表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewCarouselContentServiceImpl extends ServiceImpl<ViewCarouselContentMapper, ViewCarouselContent> implements ViewCarouselContentService {

    @Autowired
    private ViewCarouselContentMapper viewCarouselContentMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewCarouselContent recode) {
        // 分页信息
        IPage<ViewCarouselContent> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewCarouselContent> queryWrapper = new QueryWrapper<>();

        // 轮播图内容idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouselcId()), "carouselc_id", recode.getCarouselcId());
        // 轮播标题idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouselyId()), "carousely_id", recode.getCarouselyId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 图片名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 图片链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsImages()), "goods_images", recode.getGoodsImages());
        // 跳转方式（I id S 查询）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouselcJump()), "carouselc_jump", recode.getCarouselcJump());
        // 顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouselcOrder()), "carouselc_order", recode.getCarouselcOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewCarouselContent> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewCarouselContentMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewCarouselContentMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewCarouselContentMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewCarouselContent recode) {
        return R.r(viewCarouselContentMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewCarouselContent recode) {
        if (StringUtils.isEmpty(recode.getCarouselcId())) {
            throw new MissingParametersException("轮播图内容表ID");
        }
        return R.r(viewCarouselContentMapper.updateById(recode));
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
            throw new MissingParametersException("轮播图内容表ID");
        }
        return R.r(viewCarouselContentMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewCarouselContentMapper.deleteBatchIds(ids));
    }
}

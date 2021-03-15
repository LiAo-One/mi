package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewBodyGoodsdataMapper;
import com.liao.view.entity.ViewBodyGoodsdata;
import com.liao.view.services.ViewBodyGoodsdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 身体商品内容表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewBodyGoodsdataServiceImpl extends ServiceImpl<ViewBodyGoodsdataMapper, ViewBodyGoodsdata> implements ViewBodyGoodsdataService {

    @Autowired
    private ViewBodyGoodsdataMapper viewBodyGoodsdataMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewBodyGoodsdata recode) {
        // 分页信息
        IPage<ViewBodyGoodsdata> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewBodyGoodsdata> queryWrapper = new QueryWrapper<>();

        // 身体数据idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodydId()), "bodyd_id", recode.getBodydId());
        // 标题id 一级条件SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodytId()), "bodyt_id", recode.getBodytId());
        // 标题id 二级条件SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodytTypeId()), "bodyt_type_id", recode.getBodytTypeId());
        // 顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodydOrder()), "bodyd_order", recode.getBodydOrder());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 图片链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsImages()), "goods_images", recode.getGoodsImages());
        // 图片名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 现在价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodydNowPrice()), "bodyd_now_price", recode.getBodydNowPrice());
        // 原来价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodydOldPrice()), "bodyd_old_price", recode.getBodydOldPrice());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewBodyGoodsdata> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewBodyGoodsdataMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewBodyGoodsdataMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewBodyGoodsdataMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewBodyGoodsdata recode) {
        return R.r(viewBodyGoodsdataMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewBodyGoodsdata recode) {
        if (StringUtils.isEmpty(recode.getBodydId())) {
            throw new MissingParametersException("身体商品内容表ID");
        }
        return R.r(viewBodyGoodsdataMapper.updateById(recode));
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
            throw new MissingParametersException("身体商品内容表ID");
        }
        return R.r(viewBodyGoodsdataMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewBodyGoodsdataMapper.deleteBatchIds(ids));
    }
}

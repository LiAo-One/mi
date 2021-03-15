package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewHgeadContentMapper;
import com.liao.view.entity.ViewHgeadContent;
import com.liao.view.services.ViewHgeadContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 头部类别内容 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewHgeadContentServiceImpl extends ServiceImpl<ViewHgeadContentMapper, ViewHgeadContent> implements ViewHgeadContentService {

    @Autowired
    private ViewHgeadContentMapper viewHgeadContentMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewHgeadContent recode) {
        // 分页信息
        IPage<ViewHgeadContent> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewHgeadContent> queryWrapper = new QueryWrapper<>();

        // 类别内容idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHgeadcId()), "hgeadc_id", recode.getHgeadcId());
        // 类别idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHgeadyId()), "hgeady_id", recode.getHgeadyId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 图片链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsImages()), "goods_images", recode.getGoodsImages());
        // 商品名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHgeadcOrder()), "hgeadc_order", recode.getHgeadcOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewHgeadContent> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewHgeadContentMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewHgeadContentMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewHgeadContentMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewHgeadContent recode) {
        return R.r(viewHgeadContentMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewHgeadContent recode) {
        if (StringUtils.isEmpty(recode.getHgeadcId())) {
            throw new MissingParametersException("头部类别内容ID");
        }
        return R.r(viewHgeadContentMapper.updateById(recode));
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
            throw new MissingParametersException("头部类别内容ID");
        }
        return R.r(viewHgeadContentMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewHgeadContentMapper.deleteBatchIds(ids));
    }
}

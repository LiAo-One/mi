package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewCarouselTitleMapper;
import com.liao.view.entity.ViewCarouselTitle;
import com.liao.view.services.ViewCarouselTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图标题表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewCarouselTitleServiceImpl extends ServiceImpl<ViewCarouselTitleMapper, ViewCarouselTitle> implements ViewCarouselTitleService {

    @Autowired
    private ViewCarouselTitleMapper viewCarouselTitleMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewCarouselTitle recode) {
        // 分页信息
        IPage<ViewCarouselTitle> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewCarouselTitle> queryWrapper = new QueryWrapper<>();

        // 轮播图标题idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouseltId()), "carouselt_id", recode.getCarouseltId());
        // 轮播图标题名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouseltTitle()), "carouselt_title", recode.getCarouseltTitle());
        // 顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCarouseltOrder()), "carouselt_order", recode.getCarouseltOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewCarouselTitle> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewCarouselTitleMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewCarouselTitleMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewCarouselTitleMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewCarouselTitle recode) {
        return R.r(viewCarouselTitleMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewCarouselTitle recode) {
        if (StringUtils.isEmpty(recode.getCarouseltId())) {
            throw new MissingParametersException("轮播图标题表ID");
        }
        return R.r(viewCarouselTitleMapper.updateById(recode));
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
            throw new MissingParametersException("轮播图标题表ID");
        }
        return R.r(viewCarouselTitleMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewCarouselTitleMapper.deleteBatchIds(ids));
    }
}

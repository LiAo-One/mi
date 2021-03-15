package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewBottomVideoMapper;
import com.liao.view.entity.ViewBottomVideo;
import com.liao.view.services.ViewBottomVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 底部视频表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewBottomVideoServiceImpl extends ServiceImpl<ViewBottomVideoMapper, ViewBottomVideo> implements ViewBottomVideoService {

    @Autowired
    private ViewBottomVideoMapper viewBottomVideoMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewBottomVideo recode) {
        // 分页信息
        IPage<ViewBottomVideo> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewBottomVideo> queryWrapper = new QueryWrapper<>();

        // 底部视频idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVideoId()), "video_id", recode.getVideoId());
        // 视频缩略图SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVideoImages()), "video_images", recode.getVideoImages());
        // 视频链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVideoUrl()), "video_url", recode.getVideoUrl());
        // 顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVideoOrder()), "video_order", recode.getVideoOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewBottomVideo> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewBottomVideoMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewBottomVideoMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewBottomVideoMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewBottomVideo recode) {
        return R.r(viewBottomVideoMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewBottomVideo recode) {
        if (StringUtils.isEmpty(recode.getVideoId())) {
            throw new MissingParametersException("底部视频表ID");
        }
        return R.r(viewBottomVideoMapper.updateById(recode));
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
            throw new MissingParametersException("底部视频表ID");
        }
        return R.r(viewBottomVideoMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewBottomVideoMapper.deleteBatchIds(ids));
    }
}

package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsOverviewMapper;
import com.liao.goods.entity.MbsOverview;
import com.liao.goods.services.MbsOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品概述表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsOverviewServiceImpl extends ServiceImpl<MbsOverviewMapper, MbsOverview> implements MbsOverviewService {

    @Autowired
    private MbsOverviewMapper mbsOverviewMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsOverview recode) {
        // 分页信息
        IPage<MbsOverview> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsOverview> queryWrapper = new QueryWrapper<>();

        //  商品概述idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getOverviewId()), "overview_id", recode.getOverviewId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 图片链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getImagesLinke()), "images_linke", recode.getImagesLinke());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsOverview> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsOverviewMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsOverviewMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsOverviewMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsOverview recode) {
        return R.r(mbsOverviewMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsOverview recode) {
        if (StringUtils.isEmpty(recode.getOverviewId())) {
            throw new MissingParametersException("商品概述表ID");
        }
        return R.r(mbsOverviewMapper.updateById(recode));
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
            throw new MissingParametersException("商品概述表ID");
        }
        return R.r(mbsOverviewMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsOverviewMapper.deleteBatchIds(ids));
    }
}

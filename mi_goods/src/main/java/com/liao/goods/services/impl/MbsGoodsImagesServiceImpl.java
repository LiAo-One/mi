package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsGoodsImagesMapper;
import com.liao.goods.entity.MbsGoodsImages;
import com.liao.goods.services.MbsGoodsImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品附图 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsGoodsImagesServiceImpl extends ServiceImpl<MbsGoodsImagesMapper, MbsGoodsImages> implements MbsGoodsImagesService {

    @Autowired
    private MbsGoodsImagesMapper mbsGoodsImagesMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsGoodsImages recode) {
        // 分页信息
        IPage<MbsGoodsImages> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsGoodsImages> queryWrapper = new QueryWrapper<>();

        // 附图idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getImageId()), "image_id", recode.getImageId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 图片链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getImageLinke()), "image_linke", recode.getImageLinke());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreaterTime()), "creater_time", recode.getCreaterTime());

        // 排序信息
        QueryWrapper<MbsGoodsImages> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsGoodsImagesMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsGoodsImagesMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsGoodsImagesMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsGoodsImages recode) {
        return R.r(mbsGoodsImagesMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsGoodsImages recode) {
        if (StringUtils.isEmpty(recode.getImageId())) {
            throw new MissingParametersException("商品附图ID");
        }
        return R.r(mbsGoodsImagesMapper.updateById(recode));
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
            throw new MissingParametersException("商品附图ID");
        }
        return R.r(mbsGoodsImagesMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsGoodsImagesMapper.deleteBatchIds(ids));
    }
}

package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.BusinessException;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsFromAttributeMapper;
import com.liao.goods.dao.MbsGoodsImagesMapper;
import com.liao.goods.dao.MbsGoodsMapper;
import com.liao.goods.dao.MbsMainAttributeMapper;
import com.liao.goods.entity.MbsFromAttribute;
import com.liao.goods.entity.MbsGoods;
import com.liao.goods.entity.MbsGoodsImages;
import com.liao.goods.entity.MbsMainAttribute;
import com.liao.goods.services.MbsGoodsImagesService;
import com.liao.goods.services.MbsGoodsService;
import com.liao.goods.services.MbsMainAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsGoodsServiceImpl extends ServiceImpl<MbsGoodsMapper, MbsGoods> implements MbsGoodsService {

    // 商品
    @Autowired
    private MbsGoodsMapper mbsGoodsMapper;

    // 附图
    @Autowired
    private MbsGoodsImagesMapper goodsImagesMapper;

    // 一级属性Mapper
    @Autowired
    private MbsMainAttributeMapper mbsMainAttributeMapper;

    // 二级属性 Mapper
    @Autowired
    private MbsFromAttributeMapper fromAttributeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsGoods recode) {
        // 分页信息
        IPage<MbsGoods> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsGoods> queryWrapper = new QueryWrapper<>();

        // 商品主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 商品名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 商品标题SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsTitle()), "goods_title", recode.getGoodsTitle());
        // 现在的价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsNowPrice()), "goods_now_price", recode.getGoodsNowPrice());
        // 旧的价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsOldPrice()), "goods_old_price", recode.getGoodsOldPrice());
        // 商品描述SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsDepict()), "goods_depict", recode.getGoodsDepict());
        // 主图链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsMainPicture()), "goods_main_picture", recode.getGoodsMainPicture());
        // 主属性（Y N）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsMainAttributes()), "goods_main_attributes", recode.getGoodsMainAttributes());
        // 从属性（Y N）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsFromAttribute()), "goods_from_attribute", recode.getGoodsFromAttribute());
        // 参数展示方式(Y N)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsParameterWay()), "goods_parameter_way", recode.getGoodsParameterWay());
        // 是否有意外险推荐(Y N)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsAccident()), "goods_accident", recode.getGoodsAccident());
        // 是否延长保修SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsWarranty()), "goods_warranty", recode.getGoodsWarranty());
        // 是否云服务SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsCloudService()), "goods_cloud_service", recode.getGoodsCloudService());
        // 是否秒杀SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsSpike()), "goods_spike", recode.getGoodsSpike());
        // 是否赠品SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsGiveaway()), "goods_giveaway", recode.getGoodsGiveaway());
        // 是否包邮SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsFreeShipping()), "goods_free_shipping", recode.getGoodsFreeShipping());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsGoods> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsGoodsMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id) {
        return R.success(mbsGoodsMapper.selectByGoodsId(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids) {
        return R.r(mbsGoodsMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public R add(MbsGoods recode) {

        // 商品添加
        mbsGoodsMapper.insert(recode);

        // 附图入库
        if (StringUtils.isEmpty(recode.getGoodsId())) {
            throw new BusinessException("goods key exception");
        }

        // 图片入库
        insertGodosImages(recode.getGoodsId(), recode.getGoodsImages());

        // 属性集合

        if (StringUtils.isEmpty(recode.getAttributes())) {
            throw new MissingParametersException("attributes");
        }

        // 属性结合遍历入库
        insertCommodityAttributes(recode.getGoodsId(), recode.getGoodsName(), recode.getAttributes());

        return R.success();
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public R updById(MbsGoods recode) {

        // 商品id非空验证
        if (StringUtils.isEmpty(recode.getGoodsId())) {
            throw new MissingParametersException("商品表ID");
        }

        // 清空附图列表
        goodsImagesMapper.deletedGoodsImagesByGoodsId(recode.getGoodsId());
        // 图片入库
        insertGodosImages(recode.getGoodsId(), recode.getGoodsImages());
        // 清空一级属性
        mbsMainAttributeMapper.deletedMbsMainAttributeByGoodsId(recode.getGoodsId());
        // 清空二级属性
        fromAttributeMapper.deletedMbsFromAttributeByGoodsId(recode.getGoodsId());
        // 属性结合遍历入库
        insertCommodityAttributes(recode.getGoodsId(), recode.getGoodsName(), recode.getAttributes());

        return R.r(mbsGoodsMapper.updateById(recode));
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R delete(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new MissingParametersException("商品表ID");
        }
        return R.r(mbsGoodsMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids) {
        return R.r(mbsGoodsMapper.deleteBatchIds(ids));
    }

    /**
     * 商品一二级属性入库
     *
     * @param goodsId        商品Id
     * @param goodsName      商品名称
     * @param mainAttributes 商品属性集合
     */
    private void insertCommodityAttributes(Long goodsId, String goodsName, List<MbsMainAttribute> mainAttributes) {

        // 属性为空不添加
        if (StringUtils.isEmpty(mainAttributes)) {
            return;
        }

        // 商品名称
        if (StringUtils.isEmpty(goodsName)) {
            return;
        }

        // 商品id
        if (StringUtils.isEmpty(goodsId)) {
            return;
        }

        for (MbsMainAttribute attribute : mainAttributes) {
            // 商品id
            attribute.setGoodsId(goodsId);

            // 商品名称
            attribute.setGoodsName(goodsName);

            // 一级属性入库
            mbsMainAttributeMapper.insert(attribute);

            // 判断是否包含子属性
            if (StringUtils.isNotEmpty(attribute.getFromAttributes())) {
                // 子属性遍历入库
                for (MbsFromAttribute fromAttribute : attribute.getFromAttributes()) {
                    // 商品主键
                    fromAttribute.setGoodsId(goodsId);
                    // 商品名称
                    fromAttribute.setGoodsName(goodsName);
                    // 上级属性ID
                    if (StringUtils.isEmpty(attribute.getMattributeId())) {
                        throw new BusinessException("attribute key exception");
                    }
                    fromAttribute.setMattributeId(attribute.getMattributeId());
                    // 子属性入库
                    fromAttributeMapper.insert(fromAttribute);
                }
            }
        }
    }

    /**
     * 图片集合入库
     *
     * @param goodsID     商品Id
     * @param goodsImages 商品图片
     */
    private void insertGodosImages(Long goodsID, List<MbsGoodsImages> goodsImages) {

        // 为空返回
        if (StringUtils.isEmpty(goodsImages)) {
            return;
        }

        // 图片入库
        for (MbsGoodsImages goodsImage : goodsImages) {
            goodsImage.setGoodsId(goodsID);
            goodsImagesMapper.insert(goodsImage);
        }
    }
}

package com.liao.goods.dao;

import com.liao.goods.entity.MbsGoodsImages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品附图 Mapper 接口
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
public interface MbsGoodsImagesMapper extends BaseMapper<MbsGoodsImages> {

    /**
     * 根据商品id清空附图
     *
     * @param goodsId 商品Id
     * @return 影响数量
     */
    int deletedGoodsImagesByGoodsId(@Param("goodsId") Long goodsId);
}

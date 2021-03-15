package com.liao.goods.dao;

import com.liao.goods.entity.MbsMainAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 产品主属性表 Mapper 接口
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
public interface MbsMainAttributeMapper extends BaseMapper<MbsMainAttribute> {

    /**
     * 根据商品id清空一级属性
     *
     * @param goodsId 商品Id
     * @return 影响数量
     */
    int deletedMbsMainAttributeByGoodsId(@Param("goodsId") Long goodsId);
}

package com.liao.goods.dao;

import com.liao.goods.entity.MbsFromAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 产品从属性表 Mapper 接口
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
public interface MbsFromAttributeMapper extends BaseMapper<MbsFromAttribute> {

    /**
     * 根据商品id清空一级属性
     *
     * @param goodsId 商品id
     * @return 影响数量
     */
    int deletedMbsFromAttributeByGoodsId(@Param("goodsId") Long goodsId);
}

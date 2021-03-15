package com.liao.goods.dao;

import com.liao.goods.entity.MbsGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
public interface MbsGoodsMapper extends BaseMapper<MbsGoods> {

    MbsGoods selectByGoodsId(@Param("id") Long id);
}

package com.liao.goods.services;

import com.liao.commons.core.R;
import com.liao.goods.entity.MbsGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liao.goods.entity.MbsMainAttribute;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
public interface MbsGoodsService extends IService<MbsGoods> {

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
     R selPage(MbsGoods recode);

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
     R findById(Long id);

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
     R findByIds(List<Long> ids);

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
     R add(MbsGoods recode);

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
     R updById(MbsGoods recode);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
     R delete(Long id);

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
     R deletes(List<Long> ids);
}
package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsWarrantyMapper;
import com.liao.goods.entity.MbsWarranty;
import com.liao.goods.services.MbsWarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品延长保修表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsWarrantyServiceImpl extends ServiceImpl<MbsWarrantyMapper, MbsWarranty> implements MbsWarrantyService {

    @Autowired
    private MbsWarrantyMapper mbsWarrantyMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsWarranty recode) {
        // 分页信息
        IPage<MbsWarranty> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsWarranty> queryWrapper = new QueryWrapper<>();

        // 意外险idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWarrantyId()), "warranty_id", recode.getWarrantyId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 商品名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 保障服务价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGuaranteePrice()), "guarantee_price", recode.getGuaranteePrice());
        // 维修服务价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getServicePrice()), "service_price", recode.getServicePrice());
        // 置换费价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getReplacementPrice()), "replacement_price", recode.getReplacementPrice());
        // 属性顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWarrantyOrder()), "warranty_order", recode.getWarrantyOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsWarranty> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsWarrantyMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsWarrantyMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsWarrantyMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsWarranty recode) {
        return R.r(mbsWarrantyMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsWarranty recode) {
        if (StringUtils.isEmpty(recode.getWarrantyId())) {
            throw new MissingParametersException("商品延长保修表ID");
        }
        return R.r(mbsWarrantyMapper.updateById(recode));
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
            throw new MissingParametersException("商品延长保修表ID");
        }
        return R.r(mbsWarrantyMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsWarrantyMapper.deleteBatchIds(ids));
    }
}

package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsFromAttributeMapper;
import com.liao.goods.entity.MbsFromAttribute;
import com.liao.goods.services.MbsFromAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品从属性表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsFromAttributeServiceImpl extends ServiceImpl<MbsFromAttributeMapper, MbsFromAttribute> implements MbsFromAttributeService {

    @Autowired
    private MbsFromAttributeMapper mbsFromAttributeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsFromAttribute recode) {
        // 分页信息
        IPage<MbsFromAttribute> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsFromAttribute> queryWrapper = new QueryWrapper<>();

        // 从属性idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFattributeId()), "fattribute_id", recode.getFattributeId());
        // 主要属性idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMattributeId()), "mattribute_id", recode.getMattributeId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 商品名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 属性价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFattributePrice()), "fattribute_price", recode.getFattributePrice());
        // 属性顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFattributeOrder()), "fattribute_order", recode.getFattributeOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsFromAttribute> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsFromAttributeMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsFromAttributeMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsFromAttributeMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsFromAttribute recode) {
        return R.r(mbsFromAttributeMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsFromAttribute recode) {
        if (StringUtils.isEmpty(recode.getFattributeId())) {
            throw new MissingParametersException("产品从属性表ID");
        }
        return R.r(mbsFromAttributeMapper.updateById(recode));
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
            throw new MissingParametersException("产品从属性表ID");
        }
        return R.r(mbsFromAttributeMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsFromAttributeMapper.deleteBatchIds(ids));
    }
}

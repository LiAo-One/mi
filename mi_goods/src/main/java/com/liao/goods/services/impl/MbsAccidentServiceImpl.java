package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsAccidentMapper;
import com.liao.goods.entity.MbsAccident;
import com.liao.goods.services.MbsAccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品意外险表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsAccidentServiceImpl extends ServiceImpl<MbsAccidentMapper, MbsAccident> implements MbsAccidentService {

    @Autowired
    private MbsAccidentMapper mbsAccidentMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsAccident recode) {
        // 分页信息
        IPage<MbsAccident> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsAccident> queryWrapper = new QueryWrapper<>();

        // 意外险idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAccidentId()), "accident_id", recode.getAccidentId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 商品名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 属性价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAccidentPrice()), "accident_price", recode.getAccidentPrice());
        // 属性顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAccidentOrder()), "accident_order", recode.getAccidentOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsAccident> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsAccidentMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsAccidentMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsAccidentMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsAccident recode) {
        return R.r(mbsAccidentMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsAccident recode) {
        if (StringUtils.isEmpty(recode.getAccidentId())) {
            throw new MissingParametersException("商品意外险表ID");
        }
        return R.r(mbsAccidentMapper.updateById(recode));
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
            throw new MissingParametersException("商品意外险表ID");
        }
        return R.r(mbsAccidentMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsAccidentMapper.deleteBatchIds(ids));
    }
}

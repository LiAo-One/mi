package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsDescribeMapper;
import com.liao.goods.entity.MbsDescribe;
import com.liao.goods.services.MbsDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 秒杀表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsDescribeServiceImpl extends ServiceImpl<MbsDescribeMapper, MbsDescribe> implements MbsDescribeService {

    @Autowired
    private MbsDescribeMapper mbsDescribeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsDescribe recode) {
        // 分页信息
        IPage<MbsDescribe> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsDescribe> queryWrapper = new QueryWrapper<>();

        // 秒杀idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeId()), "describe_id", recode.getDescribeId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 商品名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsName()), "goods_name", recode.getGoodsName());
        // 商品标题SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsTitle()), "goods_title", recode.getGoodsTitle());
        // 现在价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeNowPrice()), "describe_now_price", recode.getDescribeNowPrice());
        // 原来价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeOldPrice()), "describe_old_price", recode.getDescribeOldPrice());
        // 秒杀开始时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeStartTime()), "describe_start_time", recode.getDescribeStartTime());
        // 秒杀结束时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeStopTime()), "describe_stop_time", recode.getDescribeStopTime());
        // 秒杀结束时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeContinuedTime()), "describe_continued_time", recode.getDescribeContinuedTime());
        // 是否首页展示(Y N)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHomeShowOff()), "home_show_off", recode.getHomeShowOff());
        // 属性顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDescribeOrder()), "describe_order", recode.getDescribeOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsDescribe> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsDescribeMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsDescribeMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsDescribeMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsDescribe recode) {
        return R.r(mbsDescribeMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsDescribe recode) {
        if (StringUtils.isEmpty(recode.getDescribeId())) {
            throw new MissingParametersException("秒杀表ID");
        }
        return R.r(mbsDescribeMapper.updateById(recode));
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
            throw new MissingParametersException("秒杀表ID");
        }
        return R.r(mbsDescribeMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsDescribeMapper.deleteBatchIds(ids));
    }
}

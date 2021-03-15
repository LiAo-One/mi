package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsHeadLabelMapper;
import com.liao.goods.entity.MbsHeadLabel;
import com.liao.goods.services.MbsHeadLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品详情头部标签表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsHeadLabelServiceImpl extends ServiceImpl<MbsHeadLabelMapper, MbsHeadLabel> implements MbsHeadLabelService {

    @Autowired
    private MbsHeadLabelMapper mbsHeadLabelMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsHeadLabel recode) {
        // 分页信息
        IPage<MbsHeadLabel> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsHeadLabel> queryWrapper = new QueryWrapper<>();

        // 头部标签idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLabelId()), "label_id", recode.getLabelId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 头部标签名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLabelName()), "label_name", recode.getLabelName());
        // 链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLabelLinke()), "label_linke", recode.getLabelLinke());
        // 是否打开新标签页面(Y N)SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLabelJump()), "label_jump", recode.getLabelJump());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsHeadLabel> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsHeadLabelMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsHeadLabelMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsHeadLabelMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsHeadLabel recode) {
        return R.r(mbsHeadLabelMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsHeadLabel recode) {
        if (StringUtils.isEmpty(recode.getLabelId())) {
            throw new MissingParametersException("商品详情头部标签表ID");
        }
        return R.r(mbsHeadLabelMapper.updateById(recode));
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
            throw new MissingParametersException("商品详情头部标签表ID");
        }
        return R.r(mbsHeadLabelMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsHeadLabelMapper.deleteBatchIds(ids));
    }
}

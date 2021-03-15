package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsParameterMapper;
import com.liao.goods.entity.MbsParameter;
import com.liao.goods.services.MbsParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品参数表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsParameterServiceImpl extends ServiceImpl<MbsParameterMapper, MbsParameter> implements MbsParameterService {

    @Autowired
    private MbsParameterMapper mbsParameterMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsParameter recode) {
        // 分页信息
        IPage<MbsParameter> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsParameter> queryWrapper = new QueryWrapper<>();

        // 商品参数idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getParameterId()), "parameter_id", recode.getParameterId());
        // 商品idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGoodsId()), "goods_id", recode.getGoodsId());
        // 图片链接SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getImagesLinke()), "images_linke", recode.getImagesLinke());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsParameter> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsParameterMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsParameterMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsParameterMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsParameter recode) {
        return R.r(mbsParameterMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsParameter recode) {
        if (StringUtils.isEmpty(recode.getParameterId())) {
            throw new MissingParametersException("商品参数表ID");
        }
        return R.r(mbsParameterMapper.updateById(recode));
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
            throw new MissingParametersException("商品参数表ID");
        }
        return R.r(mbsParameterMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsParameterMapper.deleteBatchIds(ids));
    }
}

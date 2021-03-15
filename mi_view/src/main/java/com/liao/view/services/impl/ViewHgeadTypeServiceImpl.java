package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewHgeadTypeMapper;
import com.liao.view.entity.ViewHgeadType;
import com.liao.view.services.ViewHgeadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 头部类别表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewHgeadTypeServiceImpl extends ServiceImpl<ViewHgeadTypeMapper, ViewHgeadType> implements ViewHgeadTypeService {

    @Autowired
    private ViewHgeadTypeMapper viewHgeadTypeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewHgeadType recode) {
        // 分页信息
        IPage<ViewHgeadType> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewHgeadType> queryWrapper = new QueryWrapper<>();

        // 类别idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHgeadyId()), "hgeady_id", recode.getHgeadyId());
        // 类别名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHgeadyTitle()), "hgeady_title", recode.getHgeadyTitle());
        // 属性顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHgeadyOrder()), "hgeady_order", recode.getHgeadyOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewHgeadType> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewHgeadTypeMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewHgeadTypeMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewHgeadTypeMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewHgeadType recode) {
        return R.r(viewHgeadTypeMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewHgeadType recode) {
        if (StringUtils.isEmpty(recode.getHgeadyId())) {
            throw new MissingParametersException("头部类别表ID");
        }
        return R.r(viewHgeadTypeMapper.updateById(recode));
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
            throw new MissingParametersException("头部类别表ID");
        }
        return R.r(viewHgeadTypeMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewHgeadTypeMapper.deleteBatchIds(ids));
    }
}

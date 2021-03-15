package com.liao.view.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.view.dao.ViewBodyTitleMapper;
import com.liao.view.entity.ViewBodyTitle;
import com.liao.view.services.ViewBodyTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 身体标题表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Service
public class ViewBodyTitleServiceImpl extends ServiceImpl<ViewBodyTitleMapper, ViewBodyTitle> implements ViewBodyTitleService {

    @Autowired
    private ViewBodyTitleMapper viewBodyTitleMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(ViewBodyTitle recode) {
        // 分页信息
        IPage<ViewBodyTitle> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<ViewBodyTitle> queryWrapper = new QueryWrapper<>();

        // 身体商品标题idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodytId()), "bodyt_id", recode.getBodytId());
        // 标题名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodytName()), "bodyt_name", recode.getBodytName());
        // 子父idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodytParentId()), "bodyt_parent_id", recode.getBodytParentId());
        // 类别（T 标题 C 条件）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTitleType()), "title_type", recode.getTitleType());
        // 顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBodytOrder()), "bodyt_order", recode.getBodytOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<ViewBodyTitle> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(viewBodyTitleMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(viewBodyTitleMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(viewBodyTitleMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(ViewBodyTitle recode) {
        return R.r(viewBodyTitleMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(ViewBodyTitle recode) {
        if (StringUtils.isEmpty(recode.getBodytId())) {
            throw new MissingParametersException("身体标题表ID");
        }
        return R.r(viewBodyTitleMapper.updateById(recode));
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
            throw new MissingParametersException("身体标题表ID");
        }
        return R.r(viewBodyTitleMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(viewBodyTitleMapper.deleteBatchIds(ids));
    }
}

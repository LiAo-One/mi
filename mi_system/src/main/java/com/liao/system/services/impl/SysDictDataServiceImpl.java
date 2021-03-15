package com.liao.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.system.dao.SysDictDataMapper;
import com.liao.system.entity.SysDictData;
import com.liao.system.services.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2020-12-17
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {

    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysDictData recode) {
        // 分页信息
        IPage<SysDictData> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();

        // 字典编码SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDictCode()), "dict_code", recode.getDictCode());
        // 字典排序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDictSort()), "dict_sort", recode.getDictSort());
        // 字典标签SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDictLabel()), "dict_label", recode.getDictLabel());
        // 字典键值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDictValue()), "dict_value", recode.getDictValue());
        // 字典类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDictType()), "dict_type", recode.getDictType());
        // 是否默认SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDictIsDefault()), "dict_is_default", recode.getDictIsDefault());
        // 乐观锁SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVsersion()), "vsersion", recode.getVsersion());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<SysDictData> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysDictDataMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysDictDataMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysDictDataMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysDictData recode) {
        return R.r(sysDictDataMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysDictData recode) {
        if (StringUtils.isEmpty(recode.getDictCode())) {
            throw new MissingParametersException("字典数据表ID");
        }
        return R.r(sysDictDataMapper.updateById(recode));
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
            throw new MissingParametersException("字典数据表ID");
        }
        return R.r(sysDictDataMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysDictDataMapper.deleteBatchIds(ids));
    }
}

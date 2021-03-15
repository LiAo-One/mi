package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwTillDrugMapper;
import com.longyuan.entity.SzzwTillDrug;
import com.longyuan.services.SzzwTillDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 耕地保护 农药购买与使用去向 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwTillDrugServiceImpl extends ServiceImpl<SzzwTillDrugMapper, SzzwTillDrug> implements SzzwTillDrugService {

    @Autowired
    private SzzwTillDrugMapper szzwTillDrugMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwTillDrug recode) {
        // 分页信息
        IPage<SzzwTillDrug> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwTillDrug> queryWrapper = new QueryWrapper<>();

        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDrugId()), "drug_id", recode.getDrugId());
        // 户主编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getHouseholdNum()), "household_num", recode.getHouseholdNum());
        // 农药登记编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDrugRegisterNum()), "drug_register_num", recode.getDrugRegisterNum());
        // 农药通用名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDrugCommentName()), "drug_comment_name", recode.getDrugCommentName());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUsedDrugTime()), "used_drug_time", recode.getUsedDrugTime());
        // 用药作物名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUsedDrugCrop()), "used_drug_crop", recode.getUsedDrugCrop());
        // 防虫名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDrugPest()), "drug_pest", recode.getDrugPest());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCurrentTimestamp()), "current_timestamp", recode.getCurrentTimestamp());

        // 排序信息
        QueryWrapper<SzzwTillDrug> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwTillDrugMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwTillDrugMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwTillDrugMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwTillDrug recode) {
        return R.r(szzwTillDrugMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwTillDrug recode) {
        if (StringUtils.isEmpty(recode.getDrugId())) {
            throw new MissingParametersException("耕地保护 农药购买与使用去向ID");
        }
        return R.r(szzwTillDrugMapper.updateById(recode));
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
            throw new MissingParametersException("耕地保护 农药购买与使用去向ID");
        }
        return R.r(szzwTillDrugMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwTillDrugMapper.deleteBatchIds(ids));
    }
}

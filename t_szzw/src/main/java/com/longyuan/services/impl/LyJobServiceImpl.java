package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.LyJobMapper;
import com.longyuan.entity.LyJob;
import com.longyuan.services.LyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 预警任务表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Service
public class LyJobServiceImpl extends ServiceImpl<LyJobMapper, LyJob> implements LyJobService {

    @Autowired
    private LyJobMapper lyJobMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(LyJob recode) {
        // 分页信息
        IPage<LyJob> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<LyJob> queryWrapper = new QueryWrapper<>();

        // idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobId()), "job_id", recode.getJobId());
        // 用户idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobUserid()), "job_userid", recode.getJobUserid());
        // 任务名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobName()), "job_name", recode.getJobName());
        // 传感器idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobPerceiveId()), "job_perceive_id", recode.getJobPerceiveId());
        // 传感器名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobPerceiveName()), "job_perceive_name", recode.getJobPerceiveName());
        // 最高值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobHvalue()), "job_hvalue", recode.getJobHvalue());
        // 最低值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobLvalue()), "job_lvalue", recode.getJobLvalue());
        // 最高值策略0 关 1开SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobHstrategy()), "job_hstrategy", recode.getJobHstrategy());
        // 最低值策略 0关 1开SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobLstrategy()), "job_lstrategy", recode.getJobLstrategy());
        // 控制设备idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobDev()), "job_dev", recode.getJobDev());
        // 控制设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getJobDevName()), "job_dev_name", recode.getJobDevName());
        // 是否开启（0开启 1 关闭）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStatus()), "status", recode.getStatus());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<LyJob> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(lyJobMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(lyJobMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(lyJobMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(LyJob recode) {
        return R.r(lyJobMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(LyJob recode) {
        if (StringUtils.isEmpty(recode.getJobId())) {
            throw new MissingParametersException("预警任务表ID");
        }
        return R.r(lyJobMapper.updateById(recode));
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
            throw new MissingParametersException("预警任务表ID");
        }
        return R.r(lyJobMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(lyJobMapper.deleteBatchIds(ids));
    }
}

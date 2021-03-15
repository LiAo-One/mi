package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwPpiosMapper;
import com.longyuan.entity.SzzwPpios;
import com.longyuan.services.SzzwPpiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 三乡工程人员资料表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwPpiosServiceImpl extends ServiceImpl<SzzwPpiosMapper, SzzwPpios> implements SzzwPpiosService {

    @Autowired
    private SzzwPpiosMapper szzwPpiosMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwPpios recode) {
        // 分页信息
        IPage<SzzwPpios> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwPpios> queryWrapper = new QueryWrapper<>();

        // 主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosId()), "ppios_id", recode.getPpiosId());
        // 乡镇名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosTownship()), "ppios_township", recode.getPpiosTownship());
        // 引入人才数量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosNoti()), "ppios_noti", recode.getPpiosNoti());
        // 自主创业人数SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosNoie()), "ppios_noie", recode.getPpiosNoie());
        // 三乡工程带动就业人数SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosTrpde()), "ppios_trpde", recode.getPpiosTrpde());
        // 土专家人数SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosNole()), "ppios_nole", recode.getPpiosNole());
        // 经纪人人数SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosNob()), "ppios_nob", recode.getPpiosNob());
        // 新乡贤，市民下乡人数SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosTnopgtc()), "ppios_tnopgtc", recode.getPpiosTnopgtc());
        // 填表人姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosNofp()), "ppios_nofp", recode.getPpiosNofp());
        // 填表人电话SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPpiosPhone()), "ppios_phone", recode.getPpiosPhone());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwPpios> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwPpiosMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwPpiosMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwPpiosMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwPpios recode) {
        return R.r(szzwPpiosMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwPpios recode) {
        if (StringUtils.isEmpty(recode.getPpiosId())) {
            throw new MissingParametersException("三乡工程人员资料表ID");
        }
        return R.r(szzwPpiosMapper.updateById(recode));
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
            throw new MissingParametersException("三乡工程人员资料表ID");
        }
        return R.r(szzwPpiosMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwPpiosMapper.deleteBatchIds(ids));
    }
}

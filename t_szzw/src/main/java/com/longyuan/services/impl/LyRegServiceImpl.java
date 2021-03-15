package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.LyRegMapper;
import com.longyuan.entity.LyReg;
import com.longyuan.services.LyRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 片区表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Service
public class LyRegServiceImpl extends ServiceImpl<LyRegMapper, LyReg> implements LyRegService {

    @Autowired
    private LyRegMapper lyRegMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(LyReg recode) {
        // 分页信息
        IPage<LyReg> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<LyReg> queryWrapper = new QueryWrapper<>();

        //  idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRId()), "r_id", recode.getRId());
        // 网关idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRGateId()), "r_gate_id", recode.getRGateId());
        // 片区idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRRegId()), "r_reg_id", recode.getRRegId());
        // 片区名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRRegName()), "r_reg_name", recode.getRRegName());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 更新时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<LyReg> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(lyRegMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(lyRegMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(lyRegMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(LyReg recode) {
        return R.r(lyRegMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(LyReg recode) {
        if (StringUtils.isEmpty(recode.getRId())) {
            throw new MissingParametersException("片区表ID");
        }
        return R.r(lyRegMapper.updateById(recode));
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
            throw new MissingParametersException("片区表ID");
        }
        return R.r(lyRegMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(lyRegMapper.deleteBatchIds(ids));
    }
}

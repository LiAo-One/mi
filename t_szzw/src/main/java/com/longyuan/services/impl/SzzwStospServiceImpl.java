package com.longyuan.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.longyuan.dao.SzzwStospMapper;
import com.longyuan.entity.SzzwStosp;
import com.longyuan.services.SzzwStospService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 三乡工程项目统计表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Service
public class SzzwStospServiceImpl extends ServiceImpl<SzzwStospMapper, SzzwStosp> implements SzzwStospService {

    @Autowired
    private SzzwStospMapper szzwStospMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SzzwStosp recode) {
        // 分页信息
        IPage<SzzwStosp> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SzzwStosp> queryWrapper = new QueryWrapper<>();

        // 主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospId()), "stosp_id", recode.getStospId());
        // 地区SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospRegion()), "stosp_region", recode.getStospRegion());
        // 项目内容SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospEntryname()), "stosp_entryname", recode.getStospEntryname());
        // 项目建设内容SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospProjectcontent()), "stosp_projectcontent", recode.getStospProjectcontent());
        // 项目类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospProjecttype()), "stosp_projecttype", recode.getStospProjecttype());
        // 建设性质SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospNoc()), "stosp_noc", recode.getStospNoc());
        // 投资额度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospInvestment()), "stosp_investment", recode.getStospInvestment());
        // 建设开始年度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospConstructionstartyear()), "stosp_constructionstartyear", recode.getStospConstructionstartyear());
        // 建设结束年度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospYococ()), "stosp_yococ", recode.getStospYococ());
        // 建设进度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospConstructionprogress()), "stosp_constructionprogress", recode.getStospConstructionprogress());
        // 已完成投资额度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospCompletedinvestment()), "stosp_completedinvestment", recode.getStospCompletedinvestment());
        // 吸引工商资本投入农村额度SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospAiacctia()), "stosp_aiacctia", recode.getStospAiacctia());
        // 建设地点SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospConstructionsite()), "stosp_constructionsite", recode.getStospConstructionsite());
        // 项目负责人及电话SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospPlatn()), "stosp_platn", recode.getStospPlatn());
        // 项目包挂联系人及电话SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStospCpatnopp()), "stosp_cpatnopp", recode.getStospCpatnopp());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 时间戳SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getTimeinfo()), "timeinfo", recode.getTimeinfo());

        // 排序信息
        QueryWrapper<SzzwStosp> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(szzwStospMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(szzwStospMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(szzwStospMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SzzwStosp recode) {
        return R.r(szzwStospMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SzzwStosp recode) {
        if (StringUtils.isEmpty(recode.getStospId())) {
            throw new MissingParametersException("三乡工程项目统计表ID");
        }
        return R.r(szzwStospMapper.updateById(recode));
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
            throw new MissingParametersException("三乡工程项目统计表ID");
        }
        return R.r(szzwStospMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(szzwStospMapper.deleteBatchIds(ids));
    }
}

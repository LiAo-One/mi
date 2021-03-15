package com.liao.goods.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liao.commons.core.R;
import com.liao.commons.core.page.PageUtils;
import com.liao.commons.exception.check.MissingParametersException;
import com.liao.commons.utils.StringUtils;
import com.liao.goods.dao.MbsCloudSmMapper;
import com.liao.goods.entity.MbsCloudSm;
import com.liao.goods.services.MbsCloudSmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 云套餐表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Service
public class MbsCloudSmServiceImpl extends ServiceImpl<MbsCloudSmMapper, MbsCloudSm> implements MbsCloudSmService {

    @Autowired
    private MbsCloudSmMapper mbsCloudSmMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(MbsCloudSm recode) {
        // 分页信息
        IPage<MbsCloudSm> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<MbsCloudSm> queryWrapper = new QueryWrapper<>();

        // 云套餐idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCloudSmId()), "cloud_sm_id", recode.getCloudSmId());
        // 云套餐名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCloudSmName()), "cloud_sm_name", recode.getCloudSmName());
        // 云套餐编码SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCloudSmCoding()), "cloud_sm_coding", recode.getCloudSmCoding());
        // 保障服务价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCloudSmPrice()), "cloud_sm_price", recode.getCloudSmPrice());
        // 属性顺序SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCloudSmOrder()), "cloud_sm_order", recode.getCloudSmOrder());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<MbsCloudSm> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(mbsCloudSmMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(mbsCloudSmMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(mbsCloudSmMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(MbsCloudSm recode) {
        return R.r(mbsCloudSmMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(MbsCloudSm recode) {
        if (StringUtils.isEmpty(recode.getCloudSmId())) {
            throw new MissingParametersException("云套餐表ID");
        }
        return R.r(mbsCloudSmMapper.updateById(recode));
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
            throw new MissingParametersException("云套餐表ID");
        }
        return R.r(mbsCloudSmMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(mbsCloudSmMapper.deleteBatchIds(ids));
    }
}

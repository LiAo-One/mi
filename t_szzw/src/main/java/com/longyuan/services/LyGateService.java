package com.longyuan.services;

import com.liao.commons.core.R;
import com.longyuan.entity.LyGate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 网关表 服务类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
public interface LyGateService extends IService<LyGate> {

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
     R selPage(LyGate recode);

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
     R findById(Long id);

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
     R findByIds(List<Long> ids);

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
     R add(LyGate recode);

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
     R updById(LyGate recode);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
     R delete(Long id);

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
     R deletes(List<Long> ids);
}

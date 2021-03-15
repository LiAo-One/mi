package com.liao.system.services;

import com.liao.commons.core.R;
import com.liao.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author LiAo
 * @since 2020-12-17
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    R selPage(SysRole recode);

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
     *
     *
     * @param recode 添加参数
     * @return 结果
     */


    /**
     * 添加数据
     *
     * @param recode  角色信息
     * @param menuIds 按钮信息
     * @return 结果
     */
    R add(SysRole recode, List<Long> menuIds);

    /**
     * 根据id修改
     *
     * @param recode  修改参数
     * @param menuIds 按钮id
     * @return 结果
     */
    R updById(SysRole recode, List<Long> menuIds);

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

package com.liao.system.controller;

import com.liao.commons.annotation.Log;
import com.liao.commons.core.R;
import com.liao.commons.enums.BusinessType;
import com.liao.system.entity.SysUser;
import com.liao.system.services.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2020-12-31
 */
@RestController
@RequestMapping("/sys-user")
@Api(tags = {"用户表"})
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户登录
     *
     * @param account  账号
     * @param password 密码
     * @return 结果
     */
    @PostMapping("login")
    @ApiOperation("用户登录")
    public R login(String account, String password) {
        return sysUserService.login(account, password);
    }

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(SysUser recode) {
        return sysUserService.selPage(recode);
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("sel_id")
    @ApiOperation("根据id查询数据")
    public R findById(Long id) {
        return sysUserService.findById(id);
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @PostMapping("sel_ids")
    @ApiOperation("根据ids批量查询")
    public R findByIds(@RequestParam("ids") List<Long> ids) {
        return sysUserService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    @Log(title = "用户表", businessType = BusinessType.INSERT)
    public R add(SysUser recode) {
        return sysUserService.add(recode);
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    @Log(title = "用户表", businessType = BusinessType.UPDATE)
    public R upd(SysUser recode) {
        return sysUserService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    @Log(title = "用户表", businessType = BusinessType.DELETE)
    public R delete(Long id) {
        return sysUserService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    @Log(title = "用户表", businessType = BusinessType.DELETE)
    public R deletes(@RequestParam("ids") List<Long> ids) {
        return sysUserService.deletes(ids);
    }
}

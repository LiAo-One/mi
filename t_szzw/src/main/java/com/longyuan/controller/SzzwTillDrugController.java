package com.longyuan.controller;

import com.liao.commons.core.R;
import com.liao.commons.enums.BusinessType;
import com.longyuan.entity.SzzwTillDrug;
import com.longyuan.services.SzzwTillDrugService;
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
 * 耕地保护 农药购买与使用去向 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@RestController
@RequestMapping("/szzw-till-drug")
@Api(tags = {"耕地保护 农药购买与使用去向"})
public class SzzwTillDrugController {

    @Autowired
    private SzzwTillDrugService szzwTillDrugService;

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(SzzwTillDrug recode) {
        return szzwTillDrugService.selPage(recode);
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("sel_id")
    @ApiOperation("根据id查询数据")
    public R findById(Long id){
        return szzwTillDrugService.findById(id);
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @PostMapping("sel_ids")
    @ApiOperation("根据ids批量查询")
    public R findByIds(@RequestParam("ids") List<Long> ids){
        return szzwTillDrugService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    public R add(SzzwTillDrug recode) {
        return szzwTillDrugService.add(recode);
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    public R upd(SzzwTillDrug recode) {
        return szzwTillDrugService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    public R delete(Long id){
        return szzwTillDrugService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    public R deletes(@RequestParam("ids") List<Long> ids){
        return szzwTillDrugService.deletes(ids);
    }
}

package com.liao.goods.controller;

import com.liao.commons.annotation.Log;
import com.liao.commons.core.R;
import com.liao.commons.enums.BusinessType;
import com.liao.goods.entity.MbsWarranty;
import com.liao.goods.services.MbsWarrantyService;
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
 * 商品延长保修表 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@RestController
@RequestMapping("/mbs-warranty")
@Api(tags = {"商品延长保修表"})
public class MbsWarrantyController {

    @Autowired
    private MbsWarrantyService mbsWarrantyService;

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(MbsWarranty recode) {
        return mbsWarrantyService.selPage(recode);
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
        return mbsWarrantyService.findById(id);
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
        return mbsWarrantyService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    @Log(title = "商品延长保修表",businessType = BusinessType.INSERT)
    public R add(MbsWarranty recode) {
        return mbsWarrantyService.add(recode);
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    @Log(title = "商品延长保修表",businessType = BusinessType.UPDATE)
    public R upd(MbsWarranty recode) {
        return mbsWarrantyService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    @Log(title = "商品延长保修表", businessType = BusinessType.DELETE)
    public R delete(Long id){
        return mbsWarrantyService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    @Log(title = "商品延长保修表", businessType = BusinessType.DELETE)
    public R deletes(@RequestParam("ids") List<Long> ids){
        return mbsWarrantyService.deletes(ids);
    }
}

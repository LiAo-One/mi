package com.liao.goods.controller;

import com.liao.commons.annotation.Log;
import com.liao.commons.core.R;
import com.liao.commons.enums.BusinessType;
import com.liao.goods.entity.MbsGoods;
import com.liao.goods.entity.MbsMainAttribute;
import com.liao.goods.services.MbsGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@RestController
@RequestMapping("/mbs-goods")
@Api(tags = {"商品表"})
public class MbsGoodsController {

    @Autowired
    private MbsGoodsService mbsGoodsService;

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(MbsGoods recode) {
        return mbsGoodsService.selPage(recode);
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
        return mbsGoodsService.findById(id);
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
        return mbsGoodsService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    @Log(title = "商品表", businessType = BusinessType.INSERT)
    public R add(@RequestBody MbsGoods recode) {
        return mbsGoodsService.add(recode);

    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    @Log(title = "商品表", businessType = BusinessType.UPDATE)
    public R upd(@RequestBody MbsGoods recode) {
        return mbsGoodsService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    @Log(title = "商品表", businessType = BusinessType.DELETE)
    public R delete(Long id) {
        return mbsGoodsService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    @Log(title = "商品表", businessType = BusinessType.DELETE)
    public R deletes(@RequestParam("ids") List<Long> ids) {
        return mbsGoodsService.deletes(ids);
    }
}

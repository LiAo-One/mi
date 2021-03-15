package com.liao.view.controller;

import com.liao.commons.annotation.Log;
import com.liao.commons.core.R;
import com.liao.commons.enums.BusinessType;
import com.liao.view.entity.ViewBottomVideo;
import com.liao.view.services.ViewBottomVideoService;
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
 * 底部视频表 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@RestController
@RequestMapping("/view-bottom-video")
@Api(tags = {"底部视频表"})
public class ViewBottomVideoController {

    @Autowired
    private ViewBottomVideoService viewBottomVideoService;

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(ViewBottomVideo recode) {
        return viewBottomVideoService.selPage(recode);
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
        return viewBottomVideoService.findById(id);
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
        return viewBottomVideoService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    @Log(title = "底部视频表",businessType = BusinessType.INSERT)
    public R add(ViewBottomVideo recode) {
        return viewBottomVideoService.add(recode);
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    @Log(title = "底部视频表",businessType = BusinessType.UPDATE)
    public R upd(ViewBottomVideo recode) {
        return viewBottomVideoService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    @Log(title = "底部视频表", businessType = BusinessType.DELETE)
    public R delete(Long id){
        return viewBottomVideoService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    @Log(title = "底部视频表", businessType = BusinessType.DELETE)
    public R deletes(@RequestParam("ids") List<Long> ids){
        return viewBottomVideoService.deletes(ids);
    }
}

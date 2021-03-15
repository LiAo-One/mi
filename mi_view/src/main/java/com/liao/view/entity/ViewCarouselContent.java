package com.liao.view.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 轮播图内容表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ViewCarouselContent对象", description="轮播图内容表")
public class ViewCarouselContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "轮播图内容id")
    @TableId(value = "carouselc_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long carouselcId;

    @ApiModelProperty(value = "轮播标题id")
    private Long carouselyId;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "图片名称")
    private String goodsName;

    @ApiModelProperty(value = "图片链接")
    private String goodsImages;

    @ApiModelProperty(value = "跳转方式（I id S 查询）")
    private String carouselcJump;

    @ApiModelProperty(value = "顺序")
    private Integer carouselcOrder;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

package com.liao.goods.entity;

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
 * 商品附图
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MbsGoodsImages对象", description="商品附图")
public class MbsGoodsImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附图id")
    @TableId(value = "image_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long imageId;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "图片链接")
    private String imageLinke;

    @ApiModelProperty(value = "创建时间")
    private Date createrTime;

}

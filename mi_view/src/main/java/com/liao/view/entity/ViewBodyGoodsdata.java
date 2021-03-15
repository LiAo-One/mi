package com.liao.view.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 身体商品内容表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ViewBodyGoodsdata对象", description="身体商品内容表")
public class ViewBodyGoodsdata implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身体数据id")
    @TableId(value = "bodyd_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long bodydId;

    @ApiModelProperty(value = "标题id 一级条件")
    private Long bodytId;

    @ApiModelProperty(value = "标题id 二级条件")
    private Long bodytTypeId;

    @ApiModelProperty(value = "顺序")
    private Integer bodydOrder;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "图片链接")
    private String goodsImages;

    @ApiModelProperty(value = "图片名称")
    private String goodsName;

    @ApiModelProperty(value = "现在价格")
    private BigDecimal bodydNowPrice;

    @ApiModelProperty(value = "原来价格")
    private BigDecimal bodydOldPrice;

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

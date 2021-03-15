package com.liao.goods.entity;

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
import java.util.Scanner;

/**
 * <p>
 * 产品从属性表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "MbsFromAttribute对象", description = "产品从属性表")
public class MbsFromAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "从属性id")
    @TableId(value = "fattribute_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long fattributeId;

    @ApiModelProperty(value = "主要属性id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mattributeId;

    @ApiModelProperty(value = "商品id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "从属性名称")
    private String fromName;

    @ApiModelProperty(value = "属性价格")
    private BigDecimal fattributePrice;

    @ApiModelProperty(value = "从属性数量")
    private Integer fromQuantity;

    @ApiModelProperty(value = "属性顺序")
    private Integer fattributeOrder;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

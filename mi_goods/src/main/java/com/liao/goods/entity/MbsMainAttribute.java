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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 产品主属性表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MbsMainAttribute对象", description="产品主属性表")
public class MbsMainAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主属性id")
    @TableId(value = "mattribute_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mattributeId;

    @ApiModelProperty(value = "商品id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "属性名称")
    private String attributesName;

    @ApiModelProperty(value = "属性价格")
    private BigDecimal mattributePrice;

    @ApiModelProperty(value = "属性顺序")
    private Integer mattributeOrder;

    @ApiModelProperty(value = "主属性数量")
    private Integer mainQuantity;

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

    @ApiModelProperty(value = "从属性")
    @TableField(exist = false)
    private List<MbsFromAttribute> fromAttributes = new ArrayList<>();

}

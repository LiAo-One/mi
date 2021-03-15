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

/**
 * <p>
 * 秒杀表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MbsDescribe对象", description="秒杀表")
public class MbsDescribe implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "秒杀id")
    @TableId(value = "describe_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long describeId;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品标题")
    private String goodsTitle;

    @ApiModelProperty(value = "现在价格")
    private BigDecimal describeNowPrice;

    @ApiModelProperty(value = "原来价格")
    private BigDecimal describeOldPrice;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date describeStartTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date describeStopTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date describeContinuedTime;

    @ApiModelProperty(value = "是否首页展示(Y N)")
    private String homeShowOff;

    @ApiModelProperty(value = "属性顺序")
    private Integer describeOrder;

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

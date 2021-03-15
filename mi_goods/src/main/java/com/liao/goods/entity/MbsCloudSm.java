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
 * 云套餐表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MbsCloudSm对象", description="云套餐表")
public class MbsCloudSm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "云套餐id")
    @TableId(value = "cloud_sm_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long cloudSmId;

    @ApiModelProperty(value = "云套餐名称")
    private String cloudSmName;

    @ApiModelProperty(value = "云套餐编码")
    private String cloudSmCoding;

    @ApiModelProperty(value = "保障服务价格")
    private BigDecimal cloudSmPrice;

    @ApiModelProperty(value = "属性顺序")
    private Integer cloudSmOrder;

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

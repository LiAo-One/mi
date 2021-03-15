package com.longyuan.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Perceive对象", description="")
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
public class Perceive implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "p_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pId;

    @ApiModelProperty(value = "网关")
    @JsonProperty
    private String pGate;

    @ApiModelProperty(value = "片区编号")
    @JsonProperty
    private String pArea;

    @ApiModelProperty(value = "设备名称")
    @JsonProperty
    private String pName;

    @ApiModelProperty(value = "设备编号")
    @JsonProperty
    private String pDeviceId;

    @ApiModelProperty(value = "离散变量 非离散变量")
    @JsonProperty
    private String pOp;

    @ApiModelProperty(value = "变量数值")
    @JsonProperty
    private Double pValue;

    @ApiModelProperty(value = "单位")
    @JsonProperty
    private String pUnit;

    @ApiModelProperty(value = "设备类型 0：传感器 2：控制设备")
    @JsonProperty
    private String pType;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    @JsonProperty
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonProperty
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

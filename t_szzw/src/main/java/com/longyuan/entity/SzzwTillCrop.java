package com.longyuan.entity;

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
 * 耕地保护 农作物种植情况
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwTillCrop对象", description="耕地保护 农作物种植情况")
public class SzzwTillCrop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "crop_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long cropId;

    @ApiModelProperty(value = "户主编号")
    private Integer householdNum;

    @ApiModelProperty(value = "作物种类")
    private String cropType;

    @ApiModelProperty(value = "作物面积")
    private Integer cropArea;

    @ApiModelProperty(value = "施药器材种类")
    private String drugEquiType;

    @ApiModelProperty(value = "用药次数")
    private Integer useDrugNum;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String currentTimestamp;

}

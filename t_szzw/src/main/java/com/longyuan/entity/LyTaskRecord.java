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
 * 任务执行记录表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LyTaskRecord对象", description="任务执行记录表")
public class LyTaskRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务执行记录id")
    @TableId(value = "tr_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long trId;

    @ApiModelProperty(value = "业务类型（0 数据更新 1手动控制 2 阈值任务）")
    private Integer businessType;

    @ApiModelProperty(value = "网关编号")
    private String gateId;

    @ApiModelProperty(value = "片区编号")
    private String regId;

    @ApiModelProperty(value = "设备id")
    private Long perceiveId;

    @ApiModelProperty(value = "设备名称")
    private String perceiveName;

    @ApiModelProperty(value = "设备类型（0 传感器 2控制设备）")
    private String perceiveType;

    @ApiModelProperty(value = "执行的值（控制设备：0关闭 1开，传感器：当时采集的数据）")
    private Double perceiveValue;

    @ApiModelProperty(value = "设备状态 （0 在线 1 离线）")
    private Integer perceiveStatus;

    @ApiModelProperty(value = "操作状态 0成功 1失败")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "版本控制")
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

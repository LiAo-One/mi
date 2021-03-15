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
 * 预警任务表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LyJob对象", description="预警任务表")
public class LyJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "job_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long jobId;

    @ApiModelProperty(value = "用户id")
    private Long jobUserid;

    @ApiModelProperty(value = "任务名称")
    private String jobName;

    @ApiModelProperty(value = "传感器id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long jobPerceiveId;

    @ApiModelProperty(value = "传感器名称")
    private String jobPerceiveName;

    @ApiModelProperty(value = "最高值")
    private Double jobHvalue;

    @ApiModelProperty(value = "最低值")
    private Double jobLvalue;

    @ApiModelProperty(value = "最高值策略0 关 1开")
    private Integer jobHstrategy;

    @ApiModelProperty(value = "最低值策略 0关 1开")
    private Integer jobLstrategy;

    @ApiModelProperty(value = "控制设备id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long jobDev;

    @ApiModelProperty(value = "控制设备名称")
    private String jobDevName;

    @ApiModelProperty(value = "是否开启（0开启 1 关闭）")
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

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
 * 网关表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LyGate对象", description="网关表")
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
public class LyGate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = " id")
    @TableId(value = "g_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long gId;

    @JsonProperty
    @ApiModelProperty(value = "用户id")
    private Long gUserId;

    @JsonProperty
    @ApiModelProperty(value = "网关id")
    private String gGateId;

    @JsonProperty
    @ApiModelProperty(value = "网关名称")
    private String gName;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonProperty
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonProperty
    private Date updateTime;

}

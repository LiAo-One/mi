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
 * 智慧农机表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwIamachinery对象", description="智慧农机表")
public class SzzwIamachinery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "智慧农机主键id")
    @TableId(value = "agricultural_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long agriculturalId;

    @ApiModelProperty(value = "镇，街道")
    private String town;

    @ApiModelProperty(value = "动力机械")
    private String powmachinery;

    @ApiModelProperty(value = "耕整地机械")
    private String lpmachinery;

    @ApiModelProperty(value = "种植机械")
    private String plmachinery;

    @ApiModelProperty(value = "植保机械")
    private String plpromachinery;

    @ApiModelProperty(value = "收获机械")
    private String harvester;

    @ApiModelProperty(value = "收获后处理机械")
    private String phartrmachinery;

    @ApiModelProperty(value = "秸秆处理机械")
    private String spromachinery;

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

    @ApiModelProperty(value = "自动更新时间戳")
    private Date timeinfo;

}

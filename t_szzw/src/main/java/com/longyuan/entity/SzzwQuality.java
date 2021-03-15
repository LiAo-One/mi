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
 * 质量安全表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwQuality对象", description="质量安全表")
public class SzzwQuality implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "质量安全主键id")
    @TableId(value = "quality_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long qualityId;

    @ApiModelProperty(value = "镇名")
    private String town;

    @ApiModelProperty(value = "基地名称")
    private String basename;

    @ApiModelProperty(value = "地点")
    private String place;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "联系人姓名")
    private String contactname;

    @ApiModelProperty(value = "联系人电话")
    private String telephone;

    @ApiModelProperty(value = "备注")
    private String remarks;

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

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
 * 种植科（地图地区展示）
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwPlantingmap对象", description="种植科（地图地区展示）")
public class SzzwPlantingmap implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "plantingmap_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long plantingmapId;

    @ApiModelProperty(value = "地标名称")
    private String plantingmapNameoflandmark;

    @ApiModelProperty(value = "地标子维度1")
    private String plantingmapLandmarksubone;

    @ApiModelProperty(value = "地标子维度2")
    private String plantingmapLandmarksubtwo;

    @ApiModelProperty(value = "地标子维度3")
    private String plantingmapLandmarksubthree;

    @ApiModelProperty(value = "地标子维度4")
    private String plantingmapLandmarksubfour;

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

    @ApiModelProperty(value = "时间戳")
    private Date timeinfo;

}

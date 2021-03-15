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
 * 信息入户(地图地区展示)表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwMapdisplay对象", description="信息入户(地图地区展示)表")
public class SzzwMapdisplay implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "信息入户(地图地区展示)主键id")
    @TableId(value = "mapdisplay_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mapdisplayId;

    @ApiModelProperty(value = "地区名称")
    private String districtname;

    @ApiModelProperty(value = "经度")
    private String mapLongitude;

    @ApiModelProperty(value = "纬度")
    private String mapLatitude;

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

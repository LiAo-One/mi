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
 * 三乡工程项目统计表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwStosp对象", description="三乡工程项目统计表")
public class SzzwStosp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "stosp_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stospId;

    @ApiModelProperty(value = "地区")
    private String stospRegion;

    @ApiModelProperty(value = "项目内容")
    private String stospEntryname;

    @ApiModelProperty(value = "项目建设内容")
    private String stospProjectcontent;

    @ApiModelProperty(value = "项目类型")
    private String stospProjecttype;

    @ApiModelProperty(value = "建设性质")
    private String stospNoc;

    @ApiModelProperty(value = "投资额度")
    private String stospInvestment;

    @ApiModelProperty(value = "建设开始年度")
    private String stospConstructionstartyear;

    @ApiModelProperty(value = "建设结束年度")
    private String stospYococ;

    @ApiModelProperty(value = "建设进度")
    private String stospConstructionprogress;

    @ApiModelProperty(value = "已完成投资额度")
    private String stospCompletedinvestment;

    @ApiModelProperty(value = "吸引工商资本投入农村额度")
    private String stospAiacctia;

    @ApiModelProperty(value = "建设地点")
    private String stospConstructionsite;

    @ApiModelProperty(value = "项目负责人及电话")
    private String stospPlatn;

    @ApiModelProperty(value = "项目包挂联系人及电话")
    private String stospCpatnopp;

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

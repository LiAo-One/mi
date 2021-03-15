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
 * 扶贫与社会事业
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwPovertyAlleviation对象", description="扶贫与社会事业")
public class SzzwPovertyAlleviation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "alleviation_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long alleviationId;

    private String regionName;

    @ApiModelProperty(value = "农业保险费用")
    private Double agriInsureTotal;

    @ApiModelProperty(value = "高效农业保险（万元）")
    private Double efficAgri;

    @ApiModelProperty(value = "主要种植保护（万元）")
    private Double mainPlantAgri;

    @ApiModelProperty(value = "高效农业保费占农业保险保费总额比重(%)")
    private Integer dfficAgriProportion;

    @ApiModelProperty(value = "三大主粮作物承保面积(万亩)")
    private Integer threeMainGrainPlantProportion;

    @ApiModelProperty(value = "三大主粮作物承保面积(万亩)")
    private Integer threeMainGrainContractProportion;

    @ApiModelProperty(value = " 经度(万亩)")
    private String regionJing;

    @ApiModelProperty(value = "纬度")
    private String regionWei;

    @TableField(select = false)
    @Version
    private Integer version;

    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String currentTimestamp;

}

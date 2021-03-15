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
 * 耕地保护 农药购买与使用去向
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwTillDrug对象", description="耕地保护 农药购买与使用去向")
public class SzzwTillDrug implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "drug_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long drugId;

    @ApiModelProperty(value = "户主编号")
    private Integer householdNum;

    @ApiModelProperty(value = "农药登记编号")
    private String drugRegisterNum;

    @ApiModelProperty(value = "农药通用名")
    private String drugCommentName;

    private Date usedDrugTime;

    @ApiModelProperty(value = "用药作物名称")
    private String usedDrugCrop;

    @ApiModelProperty(value = "防虫名称")
    private String drugPest;

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

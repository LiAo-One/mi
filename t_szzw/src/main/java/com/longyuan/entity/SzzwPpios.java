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
 * 三乡工程人员资料表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SzzwPpios对象", description="三乡工程人员资料表")
public class SzzwPpios implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ppios_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ppiosId;

    @ApiModelProperty(value = "乡镇名称")
    private String ppiosTownship;

    @ApiModelProperty(value = "引入人才数量")
    private String ppiosNoti;

    @ApiModelProperty(value = "自主创业人数")
    private String ppiosNoie;

    @ApiModelProperty(value = "三乡工程带动就业人数")
    private String ppiosTrpde;

    @ApiModelProperty(value = "土专家人数")
    private String ppiosNole;

    @ApiModelProperty(value = "经纪人人数")
    private String ppiosNob;

    @ApiModelProperty(value = "新乡贤，市民下乡人数")
    private String ppiosTnopgtc;

    @ApiModelProperty(value = "填表人姓名")
    private String ppiosNofp;

    @ApiModelProperty(value = "填表人电话")
    private String ppiosPhone;

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

package com.liao.system.entity;

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
 * 用户实名认证信息
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysRealName对象", description="用户实名认证信息")
public class SysRealName implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实名认证id")
    @TableId(value = "rn_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long rnId;

    @ApiModelProperty(value = "用户id")
    private Long rnUId;

    @ApiModelProperty(value = "姓名")
    private String rnName;

    @ApiModelProperty(value = "性别")
    private String rnSex;

    @ApiModelProperty(value = "出生日期")
    private Date rmBornDate;

    @ApiModelProperty(value = "身份证号码")
    private String rmIdCard;

    @ApiModelProperty(value = "身份证正面")
    private String rmPositive;

    @ApiModelProperty(value = "身份证反面")
    private String rmNegative;

    @ApiModelProperty(value = "签发机构")
    private String rmMechanism;

    @ApiModelProperty(value = "签发日期")
    @TableField("rm_Issue_date")
    private Date rmIssueDate;

    @ApiModelProperty(value = "到期时间")
    private Date rmMaturityDate;

    @ApiModelProperty(value = "乐观锁")
    private Integer vsersion;

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

}

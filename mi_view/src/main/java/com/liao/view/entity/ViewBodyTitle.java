package com.liao.view.entity;

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
 * 身体标题表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ViewBodyTitle对象", description="身体标题表")
public class ViewBodyTitle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身体商品标题id")
    @TableId(value = "bodyt_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long bodytId;

    @ApiModelProperty(value = "标题名称")
    private String bodytName;

    @ApiModelProperty(value = "子父id")
    private Long bodytParentId;

    @ApiModelProperty(value = "类别（T 标题 C 条件）")
    private String titleType;

    @ApiModelProperty(value = "顺序")
    private Integer bodytOrder;

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

}

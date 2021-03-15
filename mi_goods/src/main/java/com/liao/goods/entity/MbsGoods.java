package com.liao.goods.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MbsGoods对象", description="商品表")
public class MbsGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品主键")
    @TableId(value = "goods_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品标题")
    private String goodsTitle;

    @ApiModelProperty(value = "现在的价格")
    private BigDecimal goodsNowPrice;

    @ApiModelProperty(value = "旧的价格")
    private BigDecimal goodsOldPrice;

    @ApiModelProperty(value = "商品描述")
    private String goodsDepict;

    @ApiModelProperty(value = "主图链接")
    private String goodsMainPicture;

    @ApiModelProperty(value = "主属性（Y N）")
    private String goodsMainAttributes;

    @ApiModelProperty(value = "从属性（Y N）")
    private String goodsFromAttribute;

    @ApiModelProperty(value = "参数展示方式(Y N)")
    private String goodsParameterWay;

    @ApiModelProperty(value = "是否有意外险推荐(Y N)")
    private String goodsAccident;

    @ApiModelProperty(value = "是否延长保修")
    private String goodsWarranty;

    @ApiModelProperty(value = "是否云服务")
    private String goodsCloudService;

    @ApiModelProperty(value = "是否秒杀")
    private String goodsSpike;

    @ApiModelProperty(value = "是否赠品")
    private String goodsGiveaway;

    @ApiModelProperty(value = "是否包邮")
    private String goodsFreeShipping;

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

    @ApiModelProperty(value = "商品附图")
    @TableField(exist = false)
    private List<MbsGoodsImages> goodsImages = new ArrayList<>();

    @ApiModelProperty(value = "主属性")
    @TableField(exist = false)
    private List<MbsMainAttribute> attributes = new ArrayList<>();
}


//      水产：南京坤泰农业发展有限公司
//      大棚：南京尼康农业开发有限公司
//      水产：南京宏顺水产养殖专业合作社
//      大棚：江苏苏鲜润生态农业科技有限公司
//      水产：江宁区宝珍家庭农场
//      水产：南京顺鹏现代农业发展有限公司

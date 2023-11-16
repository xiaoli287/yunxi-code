package com.goodidea.yunxi.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goodidea.yunxi.enums.DrEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 卡券配置应用渠道表
 * </p>
 *
 * @author xiaoli
 * @since 2023-11-13
 */
@Data
@TableName("cp_coupon_channel")
@ApiModel(value = "CpCouponChannel对象", description = "卡券配置应用渠道表")
public class CpCouponChannel implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("ID")
      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("删除标记")
      private DrEnum dr;

      @ApiModelProperty("租户ID")
      private Long tenantId;

      @ApiModelProperty("实例ID")
      private Long instanceId;

      @ApiModelProperty("创建人账户名称")
      @TableField(fill = FieldFill.INSERT)
      private String createPerson;

      @ApiModelProperty("创建时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty("修改人账户名称")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private String updatePerson;

      @ApiModelProperty("更新时间")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;

      @ApiModelProperty("拓展字段内容")
      private String extension;

      @ApiModelProperty("数据迁移专用字段，开发人员不要使用")
      private String migrationCode;

      @ApiModelProperty("渠道编码")
      private String channelCode;

      @ApiModelProperty("渠道名称")
      private String channelName;


}

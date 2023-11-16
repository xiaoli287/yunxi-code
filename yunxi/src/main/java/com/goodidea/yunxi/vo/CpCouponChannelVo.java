package com.goodidea.yunxi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goodidea.yunxi.enums.DrEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CpCouponChannelVo {
    @ApiModelProperty("页大小")
    private Integer pageSize;

    @ApiModelProperty("页数")
    private Integer pageNo;

    @ApiModelProperty("删除标记")
    private DrEnum dr;

    @ApiModelProperty("租户ID")
    private Long tenantId;

    @ApiModelProperty("实例ID")
    private Long instanceId;

    @ApiModelProperty("拓展字段内容")
    private String extension;

    @ApiModelProperty("数据迁移专用字段，开发人员不要使用")
    private String migrationCode;

    @ApiModelProperty("渠道编码")
    @NotBlank(message = "渠道编码不能为空")
    private String channelCode;

    @ApiModelProperty("渠道名称")
    @NotBlank(message = "渠道名称不能为空")
    private String channelName;
}

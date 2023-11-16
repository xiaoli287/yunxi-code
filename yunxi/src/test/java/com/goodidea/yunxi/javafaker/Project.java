package com.goodidea.yunxi.javafaker;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Project {
    @ExcelProperty(value = "项目主数据ID")
    String id;

    @ExcelProperty(value = "项目编号")
    String idno;
    @ExcelProperty(value = "项目名称")
    String name;
    @ExcelProperty(value = "项目金额")
    String money;
    @ExcelProperty(value = "项目开始时间")
    String starDate;
    @ExcelProperty(value = "项目结束时间")
    String endDate;
    @ExcelProperty(value = "所属部门")
    String afhliateddept;
    @ExcelProperty(value = "项目类别(承担部门数量)")
    String projecttypedeptnumber;
    @ExcelProperty(value = "项目类别(重要程度 )")
    String project;
    @ExcelProperty(value = "项目类别(管理流程)")
    String projectType;
    @ExcelProperty(value = "项目创建日期")
    String creatdate;

    @ExcelProperty(value = "经办人")
    String opp;
    @ExcelProperty(value = "备注")
    String memo;



}

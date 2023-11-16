package com.goodidea.yunxi.javafaker;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Cumcote {
    //组织编码
    @ExcelProperty(value = "组织编码")
    String userNo;
    //组织名称
    @ExcelProperty(value = "组织名称")
    String userName;
    //上级组织
    @ExcelProperty(value = "上级组织")
    String sex;
    //组织类别
    @ExcelProperty(value = "组织类别")
    int type;
//    组织负责人编码
    @ExcelProperty(value = "组织负责人编码")
    String usersno;

    @ExcelProperty(value = "地址")
    String address;

    @ExcelProperty(value = "电话")
    String tell;

    @ExcelProperty(value = "邮箱")
    String email;

    @ExcelProperty(value = "传真")
    String taxAccount;

    @ExcelProperty(value = "生效时间")
    String kfirstdate;

    @ExcelProperty(value = "失效时间")
    String knewdate;

    @ExcelProperty(value = "备用字段1")
    String remark;
}

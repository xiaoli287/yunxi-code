package com.goodidea.yunxi.javafaker;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Shopping {
//    供应商主数据编码
    @ExcelProperty(value = "供应商主数据编码")
    String userNo;

    @ExcelProperty(value = "供应商名称")
    String userName;

    @ExcelProperty(value = "供应商简称")
    String userNameShort;

    @ExcelProperty(value = "供应商类型")
    String type;
    @ExcelProperty(value = "供应商分类")
    String classname;
    @ExcelProperty(value = "法人代表")
    String name;
    @ExcelProperty(value = "所在国家")
    String country;
    @ExcelProperty(value = "所在省份")
    String pro;
    @ExcelProperty(value = "所在城市")
    String city;
    @ExcelProperty(value = "注册地址")
    String address;
    @ExcelProperty(value = "组织机构代码/行政机构代码")
    String idcard;

    @ExcelProperty(value = "联系人")
    String names;
    @ExcelProperty(value = "联系电话")
    String phone;
    @ExcelProperty(value = "联系地址")
    String addr;

}

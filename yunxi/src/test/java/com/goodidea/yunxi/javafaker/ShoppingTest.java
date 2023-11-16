package com.goodidea.yunxi.javafaker;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.github.javafaker.Faker;
import lombok.Data;

import java.util.*;

public class ShoppingTest {
    public static void main(String[] args) {
        String citys[] = {"北京","广东","山东","江苏","河南","上海","河北","浙江","香港","山西","陕西","湖南","重庆","福建","天津","云南","四川","广西","安徽","海南","江西","湖北","山西","辽宁","内蒙古"};
        Random r = new Random();

        Faker fakerWithCN = new Faker(Locale.CHINA);
        List<Shopping> cumcotes = new ArrayList<>();

        for (int i = 0; i < 42; i++) {
            int randomInt = r.nextInt(10000)%citys.length;
            Shopping shopping = new Shopping();
            shopping.setUserNo(UUID.randomUUID().toString());
            shopping.setUserName(fakerWithCN.funnyName().name());
            shopping.setUserNameShort(fakerWithCN.funnyName().name());
            shopping.setType("个人供应商");
            shopping.setClassname("种子代制商");
            shopping.setName(fakerWithCN.name().fullName());
            shopping.setCountry("中国");
            shopping.setPro(citys[randomInt]);
            shopping.setCity(fakerWithCN.address().city());
            shopping.setAddress(fakerWithCN.address().streetAddress());
            shopping.setIdcard(UUID.randomUUID().toString());

            shopping.setNames(fakerWithCN.funnyName().name());
            shopping.setPhone(fakerWithCN.phoneNumber().cellPhone());
            shopping.setAddr(fakerWithCN.address().city()+"/"+fakerWithCN.address().streetAddress());

            System.out.println(shopping);
            cumcotes.add(shopping);
        }
        EasyExcel.write("C:\\Users\\15273\\Desktop\\客商主数据管理.xls", Shopping.class).sheet("客商主数据管理")
                .doWrite(cumcotes);
    }

}

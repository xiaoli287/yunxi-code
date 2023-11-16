package com.goodidea.yunxi.javafaker;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.excel.EasyExcel;
import com.github.javafaker.Faker;

import java.util.*;

public class JavafakerTest {


    public static void main(String[] args) {

        String citys[] = {"北京","广东","山东","江苏","河南","上海","河北","浙江","香港","山西","陕西","湖南","重庆","福建","天津","云南","四川","广西","安徽","海南","江西","湖北","山西","辽宁","内蒙古"};
        Random r = new Random();
        int randomInt = r.nextInt(10000)%citys.length;
        Faker fakerWithCN = new Faker(Locale.CHINA);
        List <Cumcote> cumcotes = new ArrayList<>();
        int a = RandomUtil.randomInt(0,32);
        for (int i = 0; i < 35; i++) {

            Cumcote userInfo = new Cumcote();

            userInfo.setUserNo(UUID.randomUUID().toString());
            userInfo.setUserName(fakerWithCN.funnyName().name());
            userInfo.setSex(fakerWithCN.funnyName().name());
            userInfo.setType(0);
            userInfo.setUsersno(UUID.randomUUID().toString());
             userInfo.setAddress(fakerWithCN.address().city()+"/"+fakerWithCN.address().streetAddress());
             userInfo.setEmail(fakerWithCN.internet().emailAddress());
            userInfo.setTell(fakerWithCN.phoneNumber().cellPhone());
             userInfo.setTaxAccount(fakerWithCN.code().asin());

            userInfo.setKfirstdate(DateUtil.format(fakerWithCN.date().birthday(),"yyyy-MM-dd HH:mm:ss"));
            userInfo.setKnewdate(DateUtil.format(fakerWithCN.date().birthday(),"yyyy-MM-dd HH:mm:ss"));



            cumcotes.add(userInfo);
            System.out.println("userInfo = " + userInfo);

        }

        EasyExcel.write("C:\\Users\\15273\\Desktop\\Cumcote.xls", Cumcote.class).sheet("组织主数据的定义及模型")
                .doWrite(cumcotes);
    }
}

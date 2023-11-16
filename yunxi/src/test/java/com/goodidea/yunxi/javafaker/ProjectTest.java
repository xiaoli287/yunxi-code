package com.goodidea.yunxi.javafaker;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.excel.EasyExcel;
import com.github.javafaker.Faker;

import java.util.*;

public class ProjectTest {
    public static void main(String[] args) {
        String citys[] = {"CXN","WWE","PPO","QQE","QQQ","MHD","YTE","NBFH","WYDX"};
        Random r = new Random();

        Faker fakerWithCN = new Faker(Locale.CHINA);
        List<Project> cumcotes = new ArrayList<>();

        for (int i = 0; i < 39; i++) {
            int randomInt = r.nextInt(10000)%citys.length;
            Project shopping = new Project();
            String data = DateUtil.format(fakerWithCN.date().birthday(),"yyyy-MM-dd HH:mm:ss");
            shopping.setId(UUID.randomUUID().toString());
            shopping.setIdno(citys[randomInt]+RandomUtil.randomInt(1,100));
            shopping.setName(fakerWithCN.funnyName().name());
            shopping.setMoney(fakerWithCN.random().nextInt(1000,100000).toString());
            shopping.setStarDate(data);
            shopping.setEndDate(DateUtil.format(fakerWithCN.date().birthday(),"yyyy-MM-dd HH:mm:ss"));
            shopping.setAfhliateddept(fakerWithCN.funnyName().name());
            shopping.setProjecttypedeptnumber("A类");
            shopping.setProject("重点");
            shopping.setProjectType("定制项目");
            shopping.setCreatdate(data);
            shopping.setOpp(fakerWithCN.name().fullName());
            shopping.setMemo(fakerWithCN.name().title());

            System.out.println(shopping);
            cumcotes.add(shopping);
        }
        EasyExcel.write("C:\\Users\\15273\\Desktop\\项目主数据管理.xls", Project.class).sheet("项目主数据管理")
                .doWrite(cumcotes);
    }

}

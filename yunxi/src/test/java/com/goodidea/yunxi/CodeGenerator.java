package com.goodidea.yunxi;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.Collections;

public class CodeGenerator {

    private static void generate() {
        String url = "jdbc:mysql://localhost:3306/test_xxl?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        // 先得到当前工程目录
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + "/yunxi/src/main/java";
        String xmlPath = projectPath + "/yunxi/src/main/resources/mapper";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("xiaoli") // 设置作者
                            .enableSwagger()        // 开启 swagger 模式 默认值:false
                            .disableOpenDir()       // 禁止打开输出目录 默认值:true
                            .outputDir(outputPath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.goodidea.yunxi") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlPath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); // add -> @@Getter and @Setter
                    builder.controllerBuilder().enableRestStyle(); // @Controller -> @RestController
                    builder.entityBuilder().columnNaming(NamingStrategy.underline_to_camel); //列名保持不变，下划线不转驼峰法
//                    builder.entityBuilder().fileOverride(); //覆盖已生成实体
                    // 设置需要生成的表名--需要的时候直接替换表名即可
                    builder.addInclude("role")
                            .addTablePrefix("t_"); // 设置过滤表前缀
                })
                .execute();

    }

    public static void main(String[] args) {
        generate();
    }
}

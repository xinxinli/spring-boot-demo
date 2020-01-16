package com.eshore.project.springbootdemo.generator;

import java.util.*;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器
 * </p>
 */
public class MpGenerator {

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        //ResourceBundle rb = ResourceBundle.getBundle("application"); //TODO 配置文件信息
        String projectPath = System.getProperty("user.dir");
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //gc.setOutputDir(projectPath+"/src/main/java");
        //gc.setOutputDir("c://");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        // .setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor("lixinxin");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("ehome");
        dsc.setPassword("ehome");
        dsc.setUrl("jdbc:mysql://132.126.3.236:3306/springmybatisdemo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "tb_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"tb_car","tb_user"}); // TODO 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("");
        //pc.setModuleName("test");
        pc.setController("com.eshore.project.springbootdemo.controller");
        pc.setService("com.eshore.project.springbootdemo.service");
        pc.setServiceImpl("com.eshore.project.springbootdemo.service.impl");
        pc.setEntity("com.eshore.project.springbootdemo.entity");
        pc.setMapper("com.eshore.project.springbootdemo.dao");
        pc.setXml("com.eshore.project.springbootdemo.mapper");
        mpg.setPackageInfo(pc);
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 执行生成
        mpg.execute();
    }

}

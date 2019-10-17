package com.crazyplay.highwan.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 
 * </p>
 * <font size=0.25>Copyright (C) 2019 Yang. All Rights Reserved.</font>
 * @author Yang Lei (Create on:Sep 3, 2019)
 * @version 1.0
 * @fileName MPG.java
 */
public class MPG {

    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String projectPath = MPG.class.getResource("/").getPath().replace("/target/classes/", "");
        System.out.println(URLDecoder.decode(projectPath, "UTF-8"));

        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        /**
         * 数据库配置
         */
        mpg.setDataSource(new DataSourceConfig().
                setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/highwan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT")
                .setUsername("root")
                .setPassword("root")
                .setTypeConvert(new MySqlTypeConvert() {
            //                  // 自定义数据库表字段类型转换【可选】
            //                  @Override
            //                  public DbColumnType processTypeConvert(String fieldType) {
            //                      System.out.println("转换类型：" + fieldType);
            //                      // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
            //                      return super.processTypeConvert(fieldType);
            //                  }
        }));

        /**
         * 策略配置
         */
        mpg.setStrategy(new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                //.setCapitalMode(true)
                // 此处可以修改为您的表前缀
                .setTablePrefix(new String[] { "t_" })
                // 表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                // 需要生成的表
                .setInclude(new String[] { "t_party_category" })
                // 排除生成的表
                //.setExclude(new String[]{"test"})
                .setRestControllerStyle(true)
                //自定义实体父类
                .setSuperEntityClass("com.crazyplay.highwan.user.pojo.BaseEntity")
//                .setSuperEntityClass(BaseEntity.class)
                .setSuperEntityColumns(new String[] {"id","is_del","create_time","create_user_id","update_time","update_user_id"})
                // 自定义 mapper 父类
                // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
                // 自定义 service 父类
                // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
                // 自定义 service 实现类父类
                // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
                // 自定义 controller 父类
                // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // strategy.setEntityColumnConstant(true);
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // strategy.setEntityBuilderModel(true);
                .setEntityLombokModel(false));
        /**
         * 包配置
         */
        mpg.setPackageInfo(new PackageConfig()
                .setParent(MPG.class.getPackage().getName())
                .setController("controller")
                .setEntity("pojo")
                .setMapper("dao")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper"));

        mpg.setGlobalConfig(new GlobalConfig()
                .setOutputDir(projectPath+"/src/main/java")
                .setFileOverride(false)
                // 不需要ActiveRecord特性的请改为false
                .setActiveRecord(false)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMa
                .setBaseResultMap(true)
                // XML columList
                .setBaseColumnList(true)
                //打开文件
                .setOpen(false)
                //是否生成 kotlin 代码
                // .setKotlin(true) 
                .setSwagger2(false)
                .setAuthor("AutoGenerator")
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController"));
        
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {

            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义 xxList.jsp 生成
        //        focList.add(new FileOutConfig("/template/list.jsp.vm") {
        //            @Override
        //            public String outputFile(TableInfo tableInfo) {
        //                // 自定义输入文件名称
        //                return "D://my_" + tableInfo.getEntityName() + ".jsp";
        //            }
        //        });

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {

            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(new TemplateConfig()
                .setXml(null)
//                .setController("/templates/controller.java.vm")
                );

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        // 打印注入设置【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}

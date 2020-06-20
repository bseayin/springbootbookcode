package com.xsz;


/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/10/9$ 19:34$
 */
        import com.baomidou.mybatisplus.core.toolkit.StringPool;
        import com.baomidou.mybatisplus.generator.AutoGenerator;
        import com.baomidou.mybatisplus.generator.InjectionConfig;
        import com.baomidou.mybatisplus.generator.config.*;
        import com.baomidou.mybatisplus.generator.config.po.TableInfo;
        import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

        import java.util.ArrayList;
        import java.util.List;

/**
 * @description:
 * @author: Bsea
 * @createDate: 2019/10/6
 * @version: 1.0
 */
public class MysqlGenerator {
    // 1.使用此代码生成器需要修改:数据库基本信息,及设置父包名,项目模块名,数据库表前缀几项
    // 2.其他设置,请自行深入代码查看参数设置
    // 3.默认生成类地址是 /src/main/java mapper.xml文件地址是 /src/main/resource下
    // 4.仅做工具使用,不讨论代码规范问题

    public static void main(String[] args) {
        // 数据库信息
        String driver = "com.mysql.cj.jdbc.Driver";
        String dataBaseUrl = "jdbc:mysql://localhost:3306/vote_db?useSSL=false&serverTimezone=Asia/Shanghai";
        String userName = "root";
        String password = "XSZ202006a";
        String tablePrefix = "";// 数据库表前缀 例:tb_user的"tb_" 没有则改为 = null即可
        String parentPackageName = "com.xsz";// 父包名
        String moduleName = "vote";// 项目模块名

        // 执行生成代码
        excuteGeneratorCode(driver, dataBaseUrl, userName, password, tablePrefix, parentPackageName, moduleName);
    }

    /**
     * 代码生成
     */
    public static void excuteGeneratorCode(String driver, String dataBaseUrl, String userName, String password,
                                           String tablePrefix, String parentPackageName, String moduleName) {
        AutoGenerator mpg = new AutoGenerator();

        // #######################全局配置#######################
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");// 文件输出地址
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(false); // 是否覆盖 默认false
        gc.setOpen(false);// 生成后自动打开文件 默认true
        gc.setAuthor("Bsea");// 作者 默认 null
        gc.setActiveRecord(false);// 不需要ActiveRecord(AR模式)特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(false);// XML ResultMap 默认false
        gc.setBaseColumnList(false);// XML columList 默认false
        // 指定生成的主键的ID类型
//		gc.setIdType(IdType.ID_WORKER);
        // 时间类型对应策略: 只使用 java.util.date 代替 默认值：TIME_PACK
//		gc.setDateType(DateType.ONLY_DATE);
        // 自定义文件命名，%s 为占位符 会自动填充表实体属性！
        gc.setControllerName("%sController");// controller 命名方式 默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // #######################数据源配置#######################
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(driver);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        // 请更改数据库名称为你的数据库名
        dsc.setUrl(dataBaseUrl);
        mpg.setDataSource(dsc);

        // #######################策略配置#######################
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀，修改为你数据库中表的前缀 如tb_user表 就填写tb_ 如果没有前缀请设置为空或注释该行代码
        strategy.setTablePrefix(new String[] { tablePrefix });// 表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        // 需要排除的表名，允许正则表达式
//        strategy.setExclude("user_info");
        strategy.setEntityLombokModel(true);// 【实体】是否为lombok模型（默认 false）
        // Boolean类型字段是否移除is前缀（默认 false）
        strategy.setEntityBooleanColumnRemoveIsPrefix(false);
        strategy.setRestControllerStyle(false);// 生成 @RestController 控制器 默认为true
        strategy.setControllerMappingHyphenStyle(true);// 驼峰转连字符 默认true
        // 乐观锁属性名称
//		strategy.setVersionFieldName("version");
        // 逻辑删除属性名称
//		strategy.setLogicDeleteFieldName("deleteMark");
        mpg.setStrategy(strategy);

        // #######################包配置#######################
        PackageConfig pc = new PackageConfig();
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent(parentPackageName);// 一般是公司域名倒写 如 com.baidu
        pc.setModuleName(moduleName);// 父包模块名 项目模块名称 如 user
        pc.setEntity("entity");// 实体类包名
        pc.setController("controller");// 控制层包名 默认为web
        pc.setService("service");// 业务接口层包名
        pc.setServiceImpl("serviceImpl");// 业务实现层包名
        pc.setMapper("mapper");// mapper接口层包名
        pc.setXml("xml");// mapper.xml包名
        mpg.setPackageInfo(pc);

        // #######################自定义配置#######################
        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        InjectionConfig injectionConfig = new InjectionConfig() {

            @Override
            public void initMap() {
                // TODO Auto-generated method stub
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 执行生成
        mpg.execute();
    }

}


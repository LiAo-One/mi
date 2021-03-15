import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Code {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取当前项目路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/mybatis-plus/src/main/java");
        // 作者名字
        gc.setAuthor("LiAo");
        // 是否打开资源管理器
        gc.setOpen(false);
        // 是否覆盖原来生成的
        gc.setFileOverride(false);
        // 去除Service I 前缀
        gc.setServiceName("%sService");
        // 主键生成策略
        gc.setIdType(IdType.ID_WORKER);
        // set 日期的类型
        gc.setDateType(DateType.ONLY_DATE);
        // Seagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mi?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("liao");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName("blog");
        pc.setParent("com.liao.mi");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setService("services");
        pc.setServiceImpl("services.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表
        strategy.setInclude((
                "mbs_accident,mbs_cloud_sm,mbs_describe,mbs_from_attribute,mbs_giveaway,mbs_goods,mbs_goods_images,mbs_head_label," +
                        "mbs_main_attribute,mbs_overview,mbs_parameter,mbs_warranty,oms_address,oms_assess," +
                        "oms_assess_reply,oms_logistics,oms_order,oms_order_goods,oms_order_track,oms_shopping_cart," +
                        "sys_admin,sys_admin_role,sys_dict_data,sys_dict_type,sys_menu,sys_open_log," +
                        "sys_real_name,sys_role,sys_role_menu,sys_user,view_body_data,view_body_title,view_bottom_video," +
                        "view_carousel_content,view_carousel_title,view_hgead_content,view_hgead_type").split(","));
        // 表明下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 列名字下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动Lombok
        strategy.setEntityLombokModel(true);
        // 逻辑删除字段
        strategy.setLogicDeleteFieldName("deleted");
        // 自动生成策略
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        // 乐观锁
        strategy.setVersionFieldName("version");
        // Controller Rest 风格
        strategy.setRestControllerStyle(true);
        // url 使用下划线命名
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // 执行代码生成器
        mpg.execute();
    }
}

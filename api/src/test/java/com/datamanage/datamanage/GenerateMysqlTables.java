package com.datamanage.datamanage;

/**
 * @author 贾佳
 * @date 2023/4/3 11:47
 */
import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenerateMysqlTables {

    // 数据库连接信息
    private static final String URL = "jdbc:mysql://localhost:3306/data-manage-platform?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // 扫描的包名
    private static final String PACKAGE_NAME = "C:\\Users\\JohnD\\Desktop\\datamanage\\api\\src\\main\\java\\com\\datamanage\\datamanage\\entity";

    @Test
    public void main() throws Exception {
        // 加载 JDBC 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取数据库连接
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 获取指定包下的所有实体类
        List<Class<?>> entityClasses = getEntityClasses(PACKAGE_NAME);

        // 依次生成数据库表
        for (Class<?> entityClass : entityClasses) {
            // 获取表名
            String tableName = getTableName(entityClass);

            // 构造 SQL 语句
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(tableName);
            sb.append(" (");

            // 获取实体类的所有字段
            Field[] fields = entityClass.getDeclaredFields();

            // 遍历字段，生成列信息
            for (Field field : fields) {
                String name = field.getName();
                if (name.equals("serialVersionUID")){
                    continue;
                }
                StringBuilder kk = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    if (Character.isUpperCase(c)) {
                        if (i == 0) {
                            continue;
                        }
                        kk.append("_");
                    }
                    kk.append(Character.toLowerCase(c));
                }
                sb.append("`").append(kk).append("`");

                if (field.getType().getSimpleName().equals("Integer")) {
                    sb.append(" INT");
                } else if (field.getType().getSimpleName().equals("Float")) {
                    sb.append(" Float(6, 2)");
                } else {
                    if (name.equals("id")) {
                        sb.append(" VARCHAR(64) NULL");
                    } else {
                        sb.append(" VARCHAR(255) NULL");
                    }
                }

                if (name.equals("id")) {
                    sb.append(" NOT NULL");
                }

                sb.append(" ,");
            }
            sb.append("PRIMARY KEY (`id`)");

            // 去掉最后一个逗号和空格
//            sb.delete(sb.length() - 2, sb.length());

            // 结束 SQL 语句
            sb.append(");");

            // 执行 SQL 语句
            Statement stmt = conn.createStatement();
            System.out.println(sb.toString());
            stmt.executeUpdate(sb.toString());
            stmt.close();
        }

        // 关闭数据库连接
        conn.close();
    }

    // 获取指定包下的所有实体类
    private static List<Class<?>> getEntityClasses(String packageName) throws Exception {
        List<Class<?>> entityClasses = new ArrayList<>();
        File packages = new File(packageName);
        File[] files = packages.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            String className = fileName.substring(0, fileName.lastIndexOf("."));
            Class<?> clazz = Class.forName("com.datamanage.datamanage.entity." + className);
            if (clazz.isAnnotationPresent(TableName.class)) {
                entityClasses.add(clazz);
            }
        }
        return entityClasses;
    }

    // 获取实体类对应的表名
    private static String getTableName(Class<?> entityClass) {
        TableName tableNameAnnotation = entityClass.getAnnotation(TableName.class);
        return tableNameAnnotation.value();
    }
}

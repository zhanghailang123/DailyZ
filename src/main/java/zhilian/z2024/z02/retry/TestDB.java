//package zhilian.z2024.z02.retry;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @author hailang.zhang
// * @since 2024-03-01
// */
//public class TestDB {
//
//    public static void main(String[] args) {
//        // 设置RDS PostgreSQL实例的连接地址
//        String hostname = "pgm-2zexuvh8g562ui07wo.pg.rds.aliyuncs.com";
//        // 设置RDS PostgreSQL实例的连接端口
//        String port = "5432";
//        // 设置待连接的数据库名
//        String dbname = "gig_contract";
//String path = "src/main/java/zhilian/z2024/z02/retry";
//        String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbname+"?binaryTransfer=true";
//
//        Properties properties = new Properties();
//        // 设置连接数据库的用户名
//        properties.setProperty("user", "web_gig_contract_user");
//        //设置连接数据库的密码
//        properties.setProperty("password", "B075B873-F8B1-467Dd-ad52-dd6660feac30");
//        // 设置证书存放路径
//
//        // 配置以SSL访问
//        properties.setProperty("ssl", "true");
//        //设置证书授权机构的公钥名
//        properties.setProperty("sslrootcert", path + "/" + "ca1.crt");
//        //设置客户端证书私钥名
//        properties.setProperty("sslkey",path +"/" + "client.pk8");
//        //设置客户端证书名
//        properties.setProperty("sslcert", path + "/" + "client.crt");
//        //填写将私钥key格式转换为pk8格式时设置的密码
//        properties.setProperty("sslpassword", "Bpo2022");
//
//        // 配置SSL模式，可选值为require、verify-ca、verify-full
//        properties.setProperty("sslmode", "verify-ca");
//
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection(jdbcUrl, properties);
//            //本示例中，假设在postgres数据库中存在表example，此处以查询表example数据为例。
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from " +
//                    "example");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                ResultSetMetaData rsmd = resultSet.getMetaData();
//                int columnCount = rsmd.getColumnCount();
//                Map map = new HashMap();
//                for (int i = 0; i < columnCount; i++) {
//                    map.put(rsmd.getColumnName(i + 1).toLowerCase(), resultSet.getObject(i + 1));
//                }
//                System.out.println(map);
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }
//}
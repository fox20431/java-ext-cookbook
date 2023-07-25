import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) {
        // JDBC连接信息
        String url = "jdbc:postgresql://localhost:5432/postgres"; // 根据实际数据库信息修改
        String username = "postgres"; // 根据实际数据库用户名修改
        String password = "postgres"; // 根据实际数据库密码修改
        String initFileName = "init.sql";

        try {
            // 加载数据库驱动
            Class.forName("org.postgresql.Driver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);

            // 初始化数据库
            initSQL(url, username, password, initFileName);

            // 创建Statement对象
            Statement statement = connection.createStatement();

            // 执行SQL查询语句
            String sqlQuery = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // 处理查询结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // 关闭资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initSQL(String url, String username, String password, String initFileName) {
        // read the init sql file
        InputStream is = JdbcExample.class.getClassLoader().getResourceAsStream(initFileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String sql = sb.toString();

        // execute the sql
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

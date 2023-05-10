package com.hihusky.testcontainers;

// import static org.testcontainers.containers.MySQLContainer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@Slf4j
public class ExampleTest {

    @Test
    void test() {
        // 创建 MySQL 容器
        MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:5.7"))
                .withUsername("test")
                .withPassword("test")
                .withDatabaseName("test_db");

        // 启动容器
        mysql.start();

        // 获取容器的连接信息
        String url = mysql.getJdbcUrl();
        String username = mysql.getUsername();
        String password = mysql.getPassword();

        // 执行测试代码
        // ...

        // 停止容器
        mysql.stop();
    }
}
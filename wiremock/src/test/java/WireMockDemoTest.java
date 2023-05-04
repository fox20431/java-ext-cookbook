import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.github.tomakehurst.wiremock.WireMockServer;

class WireMockDemoTest {

    private WireMockServer server;

    @BeforeEach
    public void setup() {
        // 创建一个新的 WireMock 服务器实例
        server = new WireMockServer(8080);

        // 启动 WireMock 服务器
        server.start();
    }

    @AfterEach
    public void teardown() {
        // 停止 WireMock 服务器
        server.stop();
    }

    @Test
    public void testMockResponse() {
        // 配置一个简单的响应
        stubFor(get(urlEqualTo("/hello")).willReturn(aResponse().withBody("Hello World")));
    }

}
package com.hihusky.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WireMockStandaloneTest {

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

    // TODO: to be finished
}

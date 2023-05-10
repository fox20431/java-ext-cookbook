package com.hihusky.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.junit.jupiter.api.Test;

/**
 * it requires docker-compose up.
 */
class WireMockTest {

    @Test
    public void testMockResponse() {
        // 配置一个简单的响应
        stubFor(get(urlEqualTo("/hello")).willReturn(aResponse().withBody("Hello World")));
    }

}
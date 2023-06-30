package com.hihusky;

import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        // 创建 Jedis 实例，连接到 Redis 服务器
        Jedis jedis = new Jedis("localhost", 6379);

        // 执行一些基本的 Redis 操作
        jedis.set("key1", "value1");
        jedis.set("key2", "value2");
        String value1 = jedis.get("key1");
        System.out.println("Value of key1: " + value1);

        // 关闭 Jedis 连接
        jedis.close();
    }
}
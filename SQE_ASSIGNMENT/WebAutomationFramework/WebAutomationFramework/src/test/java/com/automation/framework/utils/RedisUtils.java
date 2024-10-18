package com.automation.framework.utils;

import redis.clients.jedis.Jedis;

public class RedisUtils {

    private Jedis jedis;

    public RedisUtils(String host, int port) {
        jedis = new Jedis(host, port);
    }

    public String getValue(String key) {
        return jedis.get(key);
    }

    public void setValue(String key, String value) {
        jedis.set(key, value);
    }

    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }
}

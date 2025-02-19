package com.example.rbc.springbootdemo.tobedeleted;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisConnectionException;
import io.lettuce.core.api.StatefulRedisConnection;

public class TestRedisCon {
        public static void main(String[] args) {
            try {
                RedisClient client = RedisClient.create("redis://localhost:6379");
                StatefulRedisConnection<String, String> connection = client.connect();

                System.out.println("Connected to Redis!");
                connection.sync().set("key", "value");
                System.out.println("Value: " + connection.sync().get("key"));

                connection.close();
                client.shutdown();
            } catch (RedisConnectionException e) {
                System.err.println("Failed to connect to Redis: " + e.getMessage());
                // Implement fallback or retry logic
            }
        }

}

package com.example.demo;

import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

/**
 * Created by cuiyy on 2017/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoDruidTestApplication.class)
@WebAppConfiguration
public class TestRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("test1", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("test1"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User();
        user.setName("wang");
        user.setAge(18);
        user.setAddress("杭州");
        ValueOperations<String, User> operations =
                redisTemplate.opsForValue();
        operations.set("user", user);
        operations.set("user.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);

        Boolean exits = redisTemplate.hasKey("user.f");
        if (exits) {
            System.out.println("exits is true");
        } else {
            System.out.println("exits is false");
        }
    }
}

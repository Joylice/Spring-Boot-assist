package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by cuiyy on 2017/10/24.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400)
public class SessionConfig {
}

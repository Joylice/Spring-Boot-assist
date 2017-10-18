package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by cuiyy on 2017/10/18.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG = "world";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

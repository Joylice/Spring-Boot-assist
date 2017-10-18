package com.example.demo;

/**
 * Created by cuiyy on 2017/10/18.
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

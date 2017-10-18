package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cuiyy on 2017/10/18.
 */
@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
}

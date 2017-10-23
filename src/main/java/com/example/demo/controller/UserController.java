package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by cuiyy on 2017/10/23.
 */
@RestController
public class UserController {
    protected static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/save")
    public User save(String name, String address, Integer age) {
        logger.debug("save 开始");
        User u = userRepository.save(new User(null, name, age, address));
        logger.debug("save 结束");
        return u;
    }

    @RequestMapping("/findByAddress")
    public List<User> findByAddress(String address) {
        logger.debug("fa start");
        List<User> userList = userRepository.findByAddress(address);
        logger.debug("fa end");

        return userList;
    }

    @RequestMapping("/findByOptions")
    public List<User> findByOptions(String name, String address) {
        logger.debug("options");
        logger.debug("options接收参数name={},address={}", name, address);

        return userRepository.findByNameAndAddress(name, address);
    }

    @RequestMapping("/withNameAndAddressQuery")
    public List<User> withNameAndAddressQuery(String name, String address) {

        logger.debug("withNameAndAddressQuery");
        return userRepository.withNameAndAddressQurey(name, address);
    }

    @RequestMapping("/sort")
    public List<User> sort() {
        logger.debug("sort 开始");
        List<User> user = userRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return user;
    }

    @RequestMapping("/page")
    public Page<User> page() {
        logger.debug("分页开始");
        Page<User> user = userRepository.findAll(new PageRequest(1, 2));

        return user;
    }
}

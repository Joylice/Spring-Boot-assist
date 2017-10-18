package com.example.demo.controller;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by cuiyy on 2017/10/16.
 */
@RestController
@RequestMapping("/person")
public class personController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/list")
    public List<Person> queryPersonList() throws SQLException, ClassNotFoundException {
        return personDao.queryPersons();
    }
}

package com.example.demo.dao;

import com.example.demo.conn.DBConnection;
import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuiyy on 2017/10/16.
 */
@Service
public class PersonDao {

    public List<Person> queryPersons() throws SQLException, ClassNotFoundException {
        List<Person> personList = new ArrayList<Person>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM t_person");
        ResultSet rs = ps.executeQuery();


        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getString(1));
            person.setAge(rs.getInt(2));
            person.setBirthday(rs.getDate(3));
            person.setName(rs.getString(4));
            person.setRemark(rs.getString(5));
            person.setCompany_id(rs.getString(6));
            personList.add(person);
        }
        ps.close();
        rs.close();
        return personList;
    }
}

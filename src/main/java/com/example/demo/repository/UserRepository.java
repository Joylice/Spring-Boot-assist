package com.example.demo.repository;

import com.example.demo.model.Person;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cuiyy on 2017/10/23.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByAddress(String address);

    List<User> findByNameAndAddress(String name,String address);

   @Query("select u from User u where u.name=:name and u.address=:address")
    List<User>withNameAndAddressQurey(@Param("name")String name,@Param("address")String address);

}

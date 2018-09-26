package com.spring.study.controller;


import com.spring.study.bean.Student;
import com.spring.study.bean.User;
import com.spring.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


/**
 * Created by manikuttan on 6/3/18.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/users")
    public Iterable<User> getUsers() {
        return userService.getUserList();
    }

//    @RequestMapping(value = "/users/{order}")
//    public List<User> getUsersOrderBy(@PathVariable("order") String order) {
//        List<User> userList = new ArrayList<>();
//        switch (order.toLowerCase()) {
//            case "name" : userList = userService.getUserList(User.nameComparator);
//                            break;
//            case "email": userList = userService.getUserList(User.emailComparator);
//                break;
//            case "id": userList = userService.getUserList(User.idComparator);
//                break;
//        }
//        return userList;
//    }

    @RequestMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") Integer id) {
//        new ArrayList<>().forEach();
        return userService.getUser(id);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


}

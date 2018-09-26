package com.spring.study.service;

import com.spring.study.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by manikuttan on 7/3/18.
 */

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

//    private List<User> userList = Arrays.asList(
//            new User("Abin", "abin.john@gmail.com",1),
//            new User("Bibin", "bibin.au@yahoo.com",2),
//            new User("Rahul", "Rahul@gmail.com",3),
//            new User("David", "david@gmail.com",4)
//    );

    @Cacheable(cacheNames = "users")
    public List<User> getUserList() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> getUserList(Comparator<User> userComparator) {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        userList.sort(userComparator);
        return userList;
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}

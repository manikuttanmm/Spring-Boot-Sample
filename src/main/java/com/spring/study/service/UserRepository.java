package com.spring.study.service;

import com.spring.study.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



/**
 * Created by manikuttan on 7/3/18.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);
}

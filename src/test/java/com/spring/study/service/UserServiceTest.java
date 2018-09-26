package com.spring.study.service;

import com.spring.study.bean.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Arrays;
import java.util.List;

/**
 * Created by manikuttan on 16/3/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    UserService userService;

    @Mock
    User user;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<User> userList = Arrays.asList(new User("Rahul", "rahul77@gmail.com", 20),
                new User("Manu", "manumm@gmail.com", 10));

        user = userList.get(0);

        Mockito.when(userRepository.findAll()).thenReturn(userList);
        Mockito.when(userRepository.findByName(anyString())).thenReturn(user);
    }

    @Test
    public void testGetUserList() {
        List<User> result = (List<User>) userRepository.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetUser() {
        User user = userRepository.findByName("Rahul");
        assertEquals("Rahul", user.getName());
    }
}

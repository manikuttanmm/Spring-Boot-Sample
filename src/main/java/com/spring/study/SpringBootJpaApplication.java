package com.spring.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.File;
import java.io.IOException;
@SpringBootApplication
@EnableCaching
public class SpringBootJpaApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
        File temp = null;
        try {
            temp = File.createTempFile("temp-file-name", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Temp file : " + temp.getAbsolutePath());

//        System.out.println(new TestService().getValue());

    }

}

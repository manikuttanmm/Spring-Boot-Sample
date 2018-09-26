package com.spring.study.bean;
/**
 * Created by manikuttan on 24/7/18.
 */


public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age+10;
        this.name = "ABCD";
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.spring.study.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by manikuttan on 6/3/18.
 */

@Entity
public class User implements Serializable {

    @Transient
    public static final Comparator<User> nameComparator = (o1, o2) -> o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    @Transient
    public static final Comparator<User> emailComparator = (o1, o2) -> o1.getEmail().toLowerCase().compareTo(o2.getEmail().toLowerCase());

    @Transient
    public  static  final  Comparator<User> emailComparator2 = Comparator.comparing(User::getEmail);

    @Id
    @NotNull
    private Integer id;

    @Column
    @NotNull
    @Size(min = 2, max = 25, message = "Size should be minimum")
    private String name;
    @Column
    @Email
    private String email;

    public User() {
    }

    public User(String name, String email, Integer id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

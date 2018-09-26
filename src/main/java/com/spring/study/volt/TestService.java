package com.spring.study.volt;

import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by manikuttan on 25/7/18.
 */
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String,java.lang.Object>> getValue() {
        return jdbcTemplate.queryForList("SELECT * from SSC_conversion_rate;");
    }

}

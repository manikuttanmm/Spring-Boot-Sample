package com.spring.study.controller;

import com.spring.study.bean.Company;
import com.spring.study.service.CompanyService;
import com.spring.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manikuttan on 8/3/18.
 */

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/{userid}/company", method = RequestMethod.GET)
    public Iterable<Company> getCompanies(@PathVariable("userid") Integer userid) {
        return companyService.getAllCompaniesByUser(userid);
    }

    @RequestMapping(value = "/users/{userid}/company/{companyid}", method = RequestMethod.GET)
    public Company getCompanies(@PathVariable("companyid") Long companyid) {
        return companyService.getCompanyById(companyid);
    }

    @RequestMapping(value = "/users/{userid}/company", method = RequestMethod.POST)
    public void addCompany(@PathVariable("userid") Integer userid, @RequestBody Company company) {
        company.setUser(userService.getUser(userid));
        List<String> stringLis = new ArrayList<>();
        companyService.addCompany(company);
    }

}

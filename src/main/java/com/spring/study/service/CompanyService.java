package com.spring.study.service;

import com.spring.study.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;



/**
 * Created by manikuttan on 8/3/18.
 */

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Iterable<Company> getAllCompaniesByUser(Integer userid) {
        return companyRepository.findByUserId(userid);
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).get();
    }
}

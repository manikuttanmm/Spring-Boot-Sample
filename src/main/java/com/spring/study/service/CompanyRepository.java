package com.spring.study.service;

import com.spring.study.bean.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by manikuttan on 8/3/18.
 */

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface CompanyRepository extends CrudRepository<Company, Long>{

    Iterable<Company> findByUserId(Integer id);
}

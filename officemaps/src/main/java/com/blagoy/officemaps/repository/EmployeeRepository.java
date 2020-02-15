package com.blagoy.officemaps.repository;

import com.blagoy.officemaps.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}

package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(long id) {
        Optional<Employee> userOptional = employeeRepository.findById(id);
        return userOptional.orElse(null);
    }
}

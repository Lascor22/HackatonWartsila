package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.domain.WorkingTable;
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

    public void createEmployee(String name, WorkRoom workRoom, WorkingTable workingTable) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setWorkingTable(workingTable);
        employee.setWorkRoom(workRoom);
        employeeRepository.save(employee);
    }

    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }
}

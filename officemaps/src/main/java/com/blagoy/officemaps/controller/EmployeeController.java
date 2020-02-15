package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employee/{id}")
    public Employee findById(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

//    @PostMapping("employee")
//    public void create()
}

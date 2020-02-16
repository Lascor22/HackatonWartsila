package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.form.EmployeeForm;
import com.blagoy.officemaps.service.EmployeeService;
import com.blagoy.officemaps.service.WorkRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final WorkRoomService workRoomService;

    public EmployeeController(EmployeeService employeeService, WorkRoomService workRoomService) {
        this.employeeService = employeeService;
        this.workRoomService = workRoomService;
    }

    @GetMapping("employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employee/{id}")
    public Employee findById(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

    @GetMapping("employee")
    public Employee findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @PostMapping("employee")
    public void createEmployee(@RequestBody EmployeeForm employeeForm) {
        employeeService.save(employeeForm);

    }
}

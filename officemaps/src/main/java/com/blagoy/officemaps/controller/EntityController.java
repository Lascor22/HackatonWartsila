package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.service.EmployeeService;
import com.blagoy.officemaps.service.EventService;
import com.blagoy.officemaps.service.WorkRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/0")
public class EntityController {
    private final EmployeeService employeeService;
    private final WorkRoomService workRoomService;
    private final EventService eventService;


    public EntityController(EmployeeService employeeService, WorkRoomService workRoomService, EventService eventService) {
        this.employeeService = employeeService;
        this.workRoomService = workRoomService;
        this.eventService = eventService;
    }

    @GetMapping("find/{regex}")
    public Object findSomething(@PathVariable("regex") String regex) {
        try {
            long number = Long.parseLong(regex);
            WorkRoom workRoom = workRoomService.findByNumber(number);
            if (workRoom != null) {
                return workRoom;
            }
        } catch (Exception e) {

        }
        try {
            Event event = eventService.findByName(regex);
            if (event != null) {
                return event;
            }
        } catch (Exception e) {

        }
        try {
            Employee employee = employeeService.findByName(regex);
            if (employee != null) {
                return employee;
            }
        } catch (Exception e) {

        }
        return null;


    }

}

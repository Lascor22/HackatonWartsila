package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.service.EmployeeService;
import com.blagoy.officemaps.service.EventService;
import com.blagoy.officemaps.service.WorkRoomService;

public class EntityController {
    private final EmployeeService employeeService;
    private final WorkRoomService workRoomService;
    private final EventService eventService;


    public EntityController(EmployeeService employeeService, WorkRoomService workRoomService, EventService eventService) {
        this.employeeService = employeeService;
        this.workRoomService = workRoomService;
        this.eventService = eventService;
    }

    public Object findSomething(String regex) {
        try {
            long number = Long.parseLong(regex);
            WorkRoom workRoom = workRoomService.findByNumber(number);
            if (workRoom != null) {
                return null;
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

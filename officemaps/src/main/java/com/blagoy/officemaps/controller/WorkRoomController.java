package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.form.WorkRoomForm;
import com.blagoy.officemaps.service.ObjectMapService;
import com.blagoy.officemaps.service.WorkRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/0")
public class WorkRoomController extends ObjectMapController {
    private final WorkRoomService workRoomService;

    public WorkRoomController(WorkRoomService workRoomService, ObjectMapService objectMapService) {
        this.workRoomService = workRoomService;
    }

    @GetMapping("workrooms")
    public List<WorkRoom> findAll() {
        return workRoomService.findAll();
    }

    @GetMapping("workroom/id/{id}")
    public WorkRoom findById(@PathVariable("id") long id) {
        return workRoomService.findById(id);
    }

    @GetMapping("workroom/number/{number}")
    public WorkRoom findByNumber(@PathVariable("number") long number) {
        return workRoomService.findByNumber(number);
    }

    @PostMapping("workroom")
    public void createWorkingRoom(@RequestBody WorkRoomForm workRoomForm) {
        workRoomService.createWorkRoom(workRoomForm);
    }

    @GetMapping("workroom/number/{number}/employees")
    public List<Employee> findEmployeesInWorkRoom(@PathVariable("number") long number) {
        WorkRoom workRoom = findByNumber(number);
        return workRoom.getEmployees();
    }

    @GetMapping("workroom/number/{number}/events")
    public List<Event> findEventsInWorkRoom(@PathVariable("number") long number) {
        WorkRoom workRoom = findByNumber(number);
        return workRoom == null ? new ArrayList<>() : workRoom.getEvents();
    }
}

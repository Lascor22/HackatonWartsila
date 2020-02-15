package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.service.WorkRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class WorkRoomController {
    private final WorkRoomService workRoomService;

    public WorkRoomController(WorkRoomService workRoomService) {
        this.workRoomService = workRoomService;
    }

    @GetMapping("workingrooms")
    public List<WorkRoom> findAll() {
        return workRoomService.findAll();
    }

    @GetMapping("workingroom/id/{id}")
    public WorkRoom findById(@PathVariable("id") long id) {
        return workRoomService.findById(id);
    }

    @GetMapping("workingroom/number/{number}")
    public WorkRoom findByNumber(@PathVariable("number") long number) {
        return workRoomService.findByNumber(number);
    }
}

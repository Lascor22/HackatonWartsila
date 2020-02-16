package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.form.WorkRoomForm;
import com.blagoy.officemaps.service.FloorService;
import com.blagoy.officemaps.service.WorkRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/0")
public class WorkRoomController {
    private final WorkRoomService workRoomService;
    private final FloorService floorService;

    public WorkRoomController(WorkRoomService workRoomService, FloorService floorService) {
        this.workRoomService = workRoomService;
        this.floorService = floorService;
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
}

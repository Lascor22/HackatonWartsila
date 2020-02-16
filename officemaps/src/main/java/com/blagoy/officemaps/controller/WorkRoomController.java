package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.domain.WorkRoom;
import com.blagoy.officemaps.service.FloorService;
import com.blagoy.officemaps.service.WorkRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class WorkRoomController {
    private final WorkRoomService workRoomService;
    private final FloorService floorService;

    public WorkRoomController(WorkRoomService workRoomService, FloorService floorService) {
        this.workRoomService = workRoomService;
        this.floorService = floorService;
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

    @PostMapping("workingroom")
    public void createWorkingRoom(long number, long floorNumber, double x, double y, double height, double width,
                                  List<Door> doors, List<ObjectMap> neighbors) {
        workRoomService.createWorkRoom(number, floorService.findByNumber(floorNumber), x, y, height, width, doors,
                neighbors);
    }
}

package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.service.FloorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class FloorController {

    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping("floor")
    public List<Floor> findAll() {
        return floorService.findAll();
    }

    @GetMapping("floor/{number}")
    public Object getRoom(@RequestParam("x") double x, @RequestParam("y") double y, @PathVariable("number") long number) {
        Floor floor = findByNumber(number);
        if (floor == null) {
            return null;
        }
        for (WorkRoom workRoom : floor.getWorkRooms()) {
            if (isCorrect(x, y, workRoom.getCoordinateX(), workRoom.getCoordinateY(), workRoom.getWidth(), workRoom.getHeight())) {
                return workRoom;
            }
        }
        for (PublicRoom publicRoom : floor.getPublicRooms()) {
            if (isCorrect(x, y, publicRoom.getCoordinateX(), publicRoom.getCoordinateY(), publicRoom.getWidth(), publicRoom.getHeight())) {
                return publicRoom;
            }
        }
        for (Transition transition : floor.getTransitions()) {
            if (isCorrect(x, y, transition.getCoordinateX(), transition.getCoordinateY(), transition.getWidth(), transition.getHeight()) && transition.getType() != TransitionType.Corridor) {
                return transition;
            }
        }

        return null;
    }

    private boolean isCorrect(double x, double y, double roomX, double roomY, double roomW, double roomH) {
        return (x <= roomX && x >= roomX - roomW && y <= roomY && y >= roomY - roomH);
    }

    @GetMapping("floor/{id}")
    public Floor findById(@PathVariable("id") long id) {
        return floorService.findById(id);
    }

    @GetMapping("floor/number/{number}")
    public Floor findByNumber(@PathVariable("number") long number) {
        return floorService.findByNumber(number);
    }
}

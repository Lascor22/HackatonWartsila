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

        return null;
    }

//    @GetMapping("floor/directions")
//    public List<Pair<Double, Double>> getDirections(double firstX, double firstY, double secondX, double secondY, long number1, long number2) {
//        Object firstRoom = getRoom(firstX, firstY, number1);
//        Object secondRoom = getRoom(secondX, secondY, number2);
//    }

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

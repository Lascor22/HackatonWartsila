package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Floor;
import com.blagoy.officemaps.service.FloorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("floor/{id}")
    public Floor findById(@PathVariable("id") long id) {
        return floorService.findById(id);
    }
}

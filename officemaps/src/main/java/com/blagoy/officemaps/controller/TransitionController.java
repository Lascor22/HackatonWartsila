package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.domain.Transition;
import com.blagoy.officemaps.domain.TransitionType;
import com.blagoy.officemaps.service.FloorService;
import com.blagoy.officemaps.service.TransitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class TransitionController {
    private final TransitionService transitionService;
    private final FloorService floorService;

    public TransitionController(TransitionService transitionService, FloorService floorService) {
        this.transitionService = transitionService;
        this.floorService = floorService;
    }

    @GetMapping("transitions")
    public List<Transition> findAll() {
        return transitionService.findAll();
    }

    @GetMapping("transition/{id}")
    public Transition findById(@PathVariable("id") long id) {
        return transitionService.findById(id);
    }

    @PostMapping("transition")
    public void createTransition(long floorNumber, String type, double x, double y, double height, double width,
                                 List<Door> doors, List<ObjectMap> neighbors) {
        TransitionType transitionType;
        if ("Lift".equals(type)) {
            transitionType = TransitionType.Lift;
        } else if ("Stairs".equals(type)) {
            transitionType = TransitionType.Stairs;
        } else {
            transitionType = TransitionType.Corridor;
        }
        transitionService.createTransition(floorService.findByNumber(floorNumber), transitionType, x, y, height, width,
                doors, neighbors);
    }
}

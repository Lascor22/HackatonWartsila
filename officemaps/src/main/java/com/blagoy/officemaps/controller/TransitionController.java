package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Transition;
import com.blagoy.officemaps.service.TransitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class TransitionController {
    private final TransitionService transitionService;

    public TransitionController(TransitionService transitionService) {
        this.transitionService = transitionService;
    }

    @GetMapping("transitions")
    public List<Transition> findAll() {
        return transitionService.findAll();
    }

    @GetMapping("transition/{id}")
    public Transition findById(@PathVariable("id") long id) {
        return transitionService.findById(id);
    }
}

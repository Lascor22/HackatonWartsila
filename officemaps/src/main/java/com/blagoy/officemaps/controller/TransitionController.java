package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Transition;
import com.blagoy.officemaps.form.TransitionForm;
import com.blagoy.officemaps.service.ObjectMapService;
import com.blagoy.officemaps.service.TransitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class TransitionController extends ObjectMapController {
    private final TransitionService transitionService;

    public TransitionController(TransitionService transitionService, ObjectMapService objectMapService) {
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

    @PostMapping("transition")
    public void createTransition(@RequestBody TransitionForm transitionForm) {
        transitionService.createTransition(transitionForm);
    }
}

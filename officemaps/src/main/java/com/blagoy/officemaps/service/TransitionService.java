package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.form.TransitionForm;
import com.blagoy.officemaps.repository.TransitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransitionService extends ObjectMapService {
    private final TransitionRepository transitionRepository;
    private final DoorService doorService;

    public TransitionService(TransitionRepository transitionRepository, DoorService doorService) {
        this.transitionRepository = transitionRepository;
        this.doorService = doorService;
    }

    public List<Transition> findAll() {
        return transitionRepository.findAll();
    }

    public Transition findById(long id) {
        return transitionRepository.findById(id).orElse(null);
    }

    public void createTransition(TransitionForm transitionForm) {
        Transition transition = new Transition();
        transition.setType(transitionForm.getType());
        transition.setFloorNumber(transitionForm.getFloorNumber());
        transition.setHeight(transitionForm.getHeight());
        transition.setWidth(transitionForm.getWidth());
        transition.setPoint(transitionForm.getPoint());
        transition.setDoors(transitionForm.getDoors());
        transition.setNeighbors(transitionForm.getNeighbors());
        for (Door door : transition.getDoors()) {
            doorService.save(door);
        }
        transitionRepository.save(transition);
    }
}

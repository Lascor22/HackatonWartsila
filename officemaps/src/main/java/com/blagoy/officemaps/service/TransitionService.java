package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.form.TransitionForm;
import com.blagoy.officemaps.repository.TransitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransitionService {
    private final TransitionRepository transitionRepository;

    public TransitionService(TransitionRepository transitionRepository) {
        this.transitionRepository = transitionRepository;
    }

    public List<Transition> findAll() {
        return transitionRepository.findAll();
    }

    public Transition findById(long id) {
        return transitionRepository.findById(id).orElse(null);
    }

    public void createTransition(TransitionForm transitionForm, Floor floor) {
        Transition transition = new Transition();
        transition.setType(transitionForm.getType());
        transition.setFloor(floor);
        transition.setHeight(transitionForm.getHeight());
        transition.setWidth(transitionForm.getWidth());
        transition.setPoint(transitionForm.getPoint());
        transition.setDoors(transitionForm.getDoors());
        transition.setNeighbors(transitionForm.getNeighbors());
        transitionRepository.save(transition);
    }
}

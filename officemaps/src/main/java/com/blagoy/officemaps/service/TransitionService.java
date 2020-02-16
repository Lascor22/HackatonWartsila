package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Floor;
import com.blagoy.officemaps.domain.Point;
import com.blagoy.officemaps.domain.Transition;
import com.blagoy.officemaps.domain.TransitionType;
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

    public void createTransition(Floor floor, TransitionType transitionType, double x, double y,
                                 double height, double width) {
        Transition transition = new Transition();
        transition.setType(transitionType);
        transition.setFloor(floor);
        transition.setHeight(height);
        transition.setWidth(width);
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        transition.setPoint(point);
        transitionRepository.save(transition);
    }
}

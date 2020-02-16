package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.Transition;
import com.blagoy.officemaps.domain.TransitionType;
import com.blagoy.officemaps.form.TransitionForm;
import com.blagoy.officemaps.repository.ObjectMapRepository;
import com.blagoy.officemaps.repository.TransitionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransitionService extends ObjectMapService {
    private final TransitionRepository transitionRepository;
    private final DoorService doorService;
    private final PointService pointService;

    public TransitionService(ObjectMapRepository objectMapRepository, TransitionRepository transitionRepository,
                             DoorService doorService, PointService pointService) {
        super(objectMapRepository);
        this.transitionRepository = transitionRepository;
        this.doorService = doorService;
        this.pointService = pointService;
    }

    @Override
    public List<Transition> findAll() {
        return transitionRepository.findAll();
    }

    @Override
    public Transition findById(long id) {
        return transitionRepository.findById(id).orElse(null);
    }

    public void createTransition(TransitionForm transitionForm) {
        Transition transition = new Transition();
        if ("Corridor".equals(transitionForm.getType())) {
            transition.setType(TransitionType.Corridor);
        } else if ("Stairs".equals(transitionForm.getType())) {
            transition.setType(TransitionType.Stairs);
        } else {
            transition.setType(TransitionType.Lift);
        }
        transition.setFloorNumber(transitionForm.getFloorNumber());
        transition.setHeight(transitionForm.getHeight());
        transition.setWidth(transitionForm.getWidth());
        transition.setPoint(transitionForm.getPoint());
        transition.setDoors(transitionForm.getDoors());
        transition.setEvents(new ArrayList<>());
        transition.setNeighbors(transitionForm.getNeighbors());
        pointService.save(transitionForm.getPoint());
        for (Door door : transition.getDoors()) {
            doorService.save(door);
        }

        transitionRepository.save(transition);
    }

    public void save(Transition transition) {
        transitionRepository.save(transition);
    }
}

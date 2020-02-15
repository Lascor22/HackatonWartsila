package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Transition;
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
}

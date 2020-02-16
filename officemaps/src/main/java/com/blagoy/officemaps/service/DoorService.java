package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.repository.DoorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoorService {
    private final DoorRepository doorRepository;

    public DoorService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public void save(Door door) {
        doorRepository.save(door);
    }
}

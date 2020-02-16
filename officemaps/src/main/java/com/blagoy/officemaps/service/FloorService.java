package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Floor;
import com.blagoy.officemaps.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {
    private final FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<Floor> findAll() {
        return floorRepository.findAll();
    }

    public Floor findById(long id) {
        return floorRepository.findById(id).orElse(null);
    }

    public Floor findByNumber(long number) {
        return floorRepository.findByNumber(number);
    }

    public void save(Floor floor) {
        floorRepository.save(floor);
    }
}

package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.repository.PublicRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicRoomService {
    private final PublicRoomRepository floorRepository;

    public PublicRoomService(PublicRoomRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<PublicRoom> findAll() {
        return floorRepository.findAll();
    }

    public PublicRoom findById(long id) {
        return floorRepository.findById(id).orElse(null);
    }
}

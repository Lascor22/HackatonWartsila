package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.repository.PublicRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicRoomService {
    private final PublicRoomRepository publicRoomRepository;

    public PublicRoomService(PublicRoomRepository publicRoomRepository) {
        this.publicRoomRepository = publicRoomRepository;
    }

    public List<PublicRoom> findAll() {
        return publicRoomRepository.findAll();
    }

    public PublicRoom findById(long id) {
        return publicRoomRepository.findById(id).orElse(null);
    }
}

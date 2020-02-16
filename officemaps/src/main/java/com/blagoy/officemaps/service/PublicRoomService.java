package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.form.PublicRoomForm;
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

    public void createRoom(Floor floor, PublicRoomForm publicRoomForm) {
        PublicRoom publicRoom = new PublicRoom();
        publicRoom.setPoint(publicRoomForm.getPoint());
        publicRoom.setHeight(publicRoomForm.getHeight());
        publicRoom.setWidth(publicRoomForm.getWidht());
        publicRoom.setFloor(floor);
        publicRoom.setType(publicRoomForm.getType());
        publicRoom.setDoors(publicRoomForm.getDoors());
        publicRoom.setNeighbors(publicRoomForm.getNeighbors());
        publicRoomRepository.save(publicRoom);
    }
}

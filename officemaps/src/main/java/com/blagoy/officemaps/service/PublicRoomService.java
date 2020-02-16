package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.*;
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

    public void createRoom(Floor floor, PublicRoomType publicRoomType, double x, double y, double height, double width,
                           List<Door> doors, List<ObjectMap> neighbors) {
        PublicRoom publicRoom = new PublicRoom();
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        publicRoom.setPoint(point);
        publicRoom.setHeight(height);
        publicRoom.setWidth(width);
        publicRoom.setFloor(floor);
        publicRoom.setType(publicRoomType);
        publicRoom.setDoors(doors);
        publicRoom.setNeighbors(neighbors);
        publicRoomRepository.save(publicRoom);
    }
}

package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Floor;
import com.blagoy.officemaps.domain.Point;
import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.domain.PublicRoomType;
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

    public void createRoom(Floor floor, PublicRoomType publicRoomType, double x, double y, double height, double width) {
        PublicRoom publicRoom = new PublicRoom();
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        publicRoom.setPoint(point);
        publicRoom.setHeight(height);
        publicRoom.setWidth(width);
        publicRoom.setFloor(floor);
        publicRoom.setType(publicRoomType);
        publicRoomRepository.save(publicRoom);
    }
}

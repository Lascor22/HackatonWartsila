package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.form.PublicRoomForm;
import com.blagoy.officemaps.repository.ObjectMapRepository;
import com.blagoy.officemaps.repository.PublicRoomRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublicRoomService extends ObjectMapService {
    private final PublicRoomRepository publicRoomRepository;
    private final PointService pointService;
    private final DoorService doorService;

    public PublicRoomService(ObjectMapRepository objectMapRepository, PublicRoomRepository publicRoomRepository, PointService pointService, DoorService doorService) {
        super(objectMapRepository);
        this.publicRoomRepository = publicRoomRepository;
        this.pointService = pointService;
        this.doorService = doorService;
    }

    @Override
    public List<PublicRoom> findAll() {
        return publicRoomRepository.findAll();
    }

    @Override
    public PublicRoom findById(long id) {
        return publicRoomRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createRoom(PublicRoomForm publicRoomForm) {
        PublicRoom publicRoom = new PublicRoom();
        publicRoom.setPoint(publicRoomForm.getPoint());
        publicRoom.setHeight(publicRoomForm.getHeight());
        publicRoom.setWidth(publicRoomForm.getWidth());
        publicRoom.setFloor(publicRoomForm.getFloorNumber());
        publicRoom.setType(publicRoomForm.getType());
        publicRoom.setDoors(publicRoomForm.getDoors());
        publicRoom.setNeighbors(publicRoomForm.getNeighbors());
        pointService.save(publicRoomForm.getPoint());
        for (Door door : publicRoomForm.getDoors()) {
            doorService.save(door);
        }
        publicRoomRepository.save(publicRoom);
    }
}

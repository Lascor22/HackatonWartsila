package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.form.PublicRoomForm;
import com.blagoy.officemaps.service.ObjectMapService;
import com.blagoy.officemaps.service.PublicRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class PublicRoomController extends ObjectMapController {
    private final PublicRoomService publicRoomService;

    public PublicRoomController(PublicRoomService publicRoomService, ObjectMapService objectMapService) {
        super(objectMapService);
        this.publicRoomService = publicRoomService;
    }

    @GetMapping("publicRooms")
    public List<PublicRoom> findAll() {
        return publicRoomService.findAll();
    }

    @GetMapping("publicRoom/{id}")
    public PublicRoom findById(@PathVariable("id") long id) {
        return publicRoomService.findById(id);
    }

    @PostMapping("publicRoom")
    public void createRoom(@RequestBody PublicRoomForm publicRoomForm) {
        publicRoomService.createRoom(publicRoomForm);
    }

}

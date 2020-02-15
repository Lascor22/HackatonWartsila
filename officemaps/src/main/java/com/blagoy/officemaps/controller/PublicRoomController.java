package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.service.PublicRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class PublicRoomController {
    private final PublicRoomService publicRoomService;

    public PublicRoomController(PublicRoomService publicRoomService) {
        this.publicRoomService = publicRoomService;
    }

    @GetMapping("publicRoom")
    public List<PublicRoom> findAll() {
        return publicRoomService.findAll();
    }

    @GetMapping("publicRoom/{id}")
    public PublicRoom findById(@PathVariable("id") long id) {
        return publicRoomService.findById(id);
    }

}

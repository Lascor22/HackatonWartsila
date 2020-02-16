package com.blagoy.officemaps.controller;


import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.domain.PublicRoom;
import com.blagoy.officemaps.domain.PublicRoomType;
import com.blagoy.officemaps.service.FloorService;
import com.blagoy.officemaps.service.PublicRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class PublicRoomController {
    private final PublicRoomService publicRoomService;
    private final FloorService floorService;

    public PublicRoomController(PublicRoomService publicRoomService, FloorService floorService) {
        this.publicRoomService = publicRoomService;
        this.floorService = floorService;
    }

    @GetMapping("publicRoom")
    public List<PublicRoom> findAll() {
        return publicRoomService.findAll();
    }

    @GetMapping("publicRoom/{id}")
    public PublicRoom findById(@PathVariable("id") long id) {
        return publicRoomService.findById(id);
    }

    @PostMapping("publicRoom")
    public void createRoom(long floorNumber, String type, double x, double y, double height, double width,
                           List<Door> doors, List<ObjectMap> neighbors) {
        PublicRoomType publicRoomType;
        if ("Toilet".equals(type)) {
            publicRoomType = PublicRoomType.Toilet;
        } else {
            publicRoomType = PublicRoomType.CoffeePoint;
        }


        publicRoomService.createRoom(floorService.findByNumber(floorNumber), publicRoomType, x, y, height, width,
                doors, neighbors);
    }

}

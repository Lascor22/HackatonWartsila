package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.form.EventForm;
import com.blagoy.officemaps.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class EventController {
    private final EventService eventService;
    private final WorkRoomService workRoomService;
    private final TransitionService transitionService;
    private final PublicRoomService publicRoomService;

    public EventController(EventService eventService, WorkRoomService workRoomService, TransitionService transitionService, PublicRoomService publicRoomService) {
        this.eventService = eventService;
        this.workRoomService = workRoomService;
        this.transitionService = transitionService;
        this.publicRoomService = publicRoomService;
    }

    @GetMapping("events")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PostMapping("event")
    public void createEvent(@RequestBody EventForm eventForm) {
        ObjectMap objectMap = null, tempMap;
        try {
            tempMap = workRoomService.findById(eventForm.getRoomId());
            if (tempMap != null) {
                objectMap = tempMap;
            }
        } catch (Exception e) {

        }
        try {
            tempMap = transitionService.findById(eventForm.getRoomId());
            if (tempMap != null) {
                objectMap = tempMap;
            }
        } catch (Exception e) {}
        try {
            tempMap = publicRoomService.findById(eventForm.getRoomId());
            if (tempMap != null) {
                objectMap = tempMap;
            }
        } catch (Exception e) {

        }
        eventService.createEvent(eventForm, objectMap);
    }

    @GetMapping("event/{id}")
    public Event findById(@PathVariable("id") long id) {
        return eventService.findById(id);
    }
}

package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("events")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PostMapping("event")
    public void createEvent() {
        //TODO
    }

    @GetMapping("event/{id}")
    public Event findById(@PathVariable("id") long id) {
        return eventService.findById(id);
    }
}

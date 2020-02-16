package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.form.EventForm;
import com.blagoy.officemaps.service.EventService;
import com.blagoy.officemaps.service.ObjectMapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0")
public class EventController {
    private final EventService eventService;
    private final ObjectMapService objectMapService;

    public EventController(EventService eventService, ObjectMapService objectMapService) {
        this.eventService = eventService;
        this.objectMapService = objectMapService;
    }

    @GetMapping("events")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PostMapping("event")
    public void createEvent(@RequestBody EventForm eventForm) {
        ObjectMap room = objectMapService.findById(eventForm.getRoomId());
        eventService.createEvent(eventForm, room);
    }

    @GetMapping("event/{id}")
    public Event findById(@PathVariable("id") long id) {
        return eventService.findById(id);
    }
}

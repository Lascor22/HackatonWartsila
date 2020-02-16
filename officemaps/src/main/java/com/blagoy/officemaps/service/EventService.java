package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.form.EventForm;
import com.blagoy.officemaps.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void create(Event event) {
        eventRepository.save(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void createEvent(EventForm eventForm, ObjectMap objectMap) {
        Event event = new Event();
        event.setEmployeeList(eventForm.getEmployees());
        event.setObjectMap(objectMap);
        event.setName(event.getName());
        event.setCreator(eventForm.getCreator());
        event.setDescription(eventForm.getDescription());
        eventRepository.save(event);
    }
}

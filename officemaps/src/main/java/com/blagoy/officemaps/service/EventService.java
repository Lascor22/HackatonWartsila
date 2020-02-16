package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.ObjectMap;
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

    public void createEvent(String name, ObjectMap room, List<Employee> employees, Employee creator) {
        Event event = new Event();
        event.setEmployeeList(employees);
        event.setObjectMap(room);
        event.setName(name);
        event.setCreator(creator);
        eventRepository.save(event);
    }
}

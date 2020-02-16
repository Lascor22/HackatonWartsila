package com.blagoy.officemaps.service;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.Event;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.form.EventForm;
import com.blagoy.officemaps.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EmployeeService employeeService;

    public EventService(EventRepository eventRepository, EmployeeService employeeService) {
        this.eventRepository = eventRepository;
        this.employeeService = employeeService;
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
        Employee creator = employeeService.findByName(eventForm.getCreator());
        List<Employee> employees = eventForm.getEmployees().stream().map(name -> employeeService.findByName(name)).collect(Collectors.toList());
        event.setEmployeeList(employees);
        event.setObjectMap(objectMap);
        event.setName(eventForm.getName());
        event.setCreator(creator);
        event.setDescription(eventForm.getDescription());
        eventRepository.save(event);
    }

    public Event findByName(String name) {
        return eventRepository.findByName(name);
    }
}

package com.blagoy.officemaps.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotNull
    private String name;

    @OneToOne
    private WorkingTable workingTable;

    public WorkRoom getWorkRoom() {
        return workRoom;
    }

    public void setWorkRoom(WorkRoom workRoom) {
        this.workRoom = workRoom;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private WorkRoom workRoom;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_event",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @CreationTimestamp
    private Date creationTime;

    public WorkingTable getWorkingTable() {
        return workingTable;
    }

    public void setWorkingTable(WorkingTable workingTable) {
        this.workingTable = workingTable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

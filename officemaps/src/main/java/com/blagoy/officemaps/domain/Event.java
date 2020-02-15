package com.blagoy.officemaps.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Document(value = "Event")
public class Event {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    @Field(value = "EmployeeList")
    private List<Employee> employeeList;

    @NotNull
    @NotEmpty
    @Field(value = "Room")
    private ObjectMap room;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public ObjectMap getRoom() {
        return room;
    }

    public void setRoom(ObjectMap room) {
        this.room = room;
    }
}

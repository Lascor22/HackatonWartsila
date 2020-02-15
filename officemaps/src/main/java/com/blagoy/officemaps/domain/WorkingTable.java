package com.blagoy.officemaps.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Document(collection = "WorkingTable")
public class WorkingTable {
    @Id
    @GeneratedValue
    private long id;

    @Field(value = "number")
    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @NotNull
    @NotEmpty
    @Field(value = "Employee")
    private Employee employee;

    @NotEmpty
    @NotNull
    @Field(value = "WorkRoom")
    private WorkRoom workRoom;

    public WorkRoom getWorkRoom() {
        return workRoom;
    }

    public void setWorkRoom(WorkRoom workRoom) {
        this.workRoom = workRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

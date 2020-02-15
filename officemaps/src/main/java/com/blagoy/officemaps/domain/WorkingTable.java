package com.blagoy.officemaps.domain;

import javax.persistence.Entity;

@Entity

public class WorkingTable {
    private long id;

    private Employee employee;

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

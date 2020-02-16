package com.blagoy.officemaps.form;

import com.blagoy.officemaps.domain.Employee;
import com.blagoy.officemaps.domain.WorkRoom;

public class WorkingTableForm {
    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public WorkRoom getWorkRoom() {
        return workRoom;
    }

    public void setWorkRoom(WorkRoom workRoom) {
        this.workRoom = workRoom;
    }

    private Employee employee;
    private WorkRoom workRoom;
}

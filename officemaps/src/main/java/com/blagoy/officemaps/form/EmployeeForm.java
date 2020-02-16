package com.blagoy.officemaps.form;

public class EmployeeForm {

    private String name;
    private long roomNumber;
    private long workingTableNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getWorkingTableNumber() {
        return workingTableNumber;
    }

    public void setWorkingTableNumber(long workingTableNumber) {
        this.workingTableNumber = workingTableNumber;
    }
}

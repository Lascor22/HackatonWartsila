package com.blagoy.officemaps.domain;


import javax.persistence.*;

@Entity
@Table
public class WorkingTable {
    @Id
    @GeneratedValue
    private long id;

    @JoinColumn(name = "number", nullable = false)
    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @OneToOne
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
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

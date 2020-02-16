package com.blagoy.officemaps.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "number"))
public class WorkRoom extends ObjectMap {

    @JoinColumn(name = "number", nullable = false)
    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @CreationTimestamp
    private Date creationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Floor floor;

    @OneToMany(mappedBy = "workRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;

    @OneToMany(mappedBy = "workRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkingTable> workingTables;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<WorkingTable> getWorkingTables() {
        return workingTables;
    }

    public void setWorkingTables(List<WorkingTable> workingTables) {
        this.workingTables = workingTables;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}

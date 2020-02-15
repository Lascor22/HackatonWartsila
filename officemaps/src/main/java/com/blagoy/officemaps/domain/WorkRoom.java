package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "number"))
public class WorkRoom extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    private long number;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @CreationTimestamp
    private Date creationTime;

    @NotEmpty
    @NotNull
    private List<Employee> employees;

    @NotNull
    @NotEmpty
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
}

package com.blagoy.officemaps.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        indexes = @Index(columnList = "creationTime")
)
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    @NotNull
    private String name;

    private WorkingTable workingTable;

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
}

package com.blagoy.officemaps.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Document(collation = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    @Field(value = "Name")
    private String name;

    @NotNull
    @NotEmpty
    @Field(value = "WorkingTable")
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

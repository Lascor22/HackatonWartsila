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
@Document(collection = "WorkRoom")
public class WorkRoom extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    @Field(value = "number")
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

    @NotEmpty
    @NotNull
    @Field(value = "Employees")
    private List<Employee> employees;

    @NotNull
    @NotEmpty
    @Field(value = "WorkingTables")
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
}

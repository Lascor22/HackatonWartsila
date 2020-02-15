package com.blagoy.officemaps.domain;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class WorkRoom extends ObjectMap {

    private List<Employee> employees;

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

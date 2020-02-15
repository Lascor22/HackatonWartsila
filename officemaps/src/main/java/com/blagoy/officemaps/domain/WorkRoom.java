package com.blagoy.officemaps.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "number"))
public class WorkRoom {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotEmpty
    @JoinColumn(name = "number", nullable = false)
    private long number;

    public long getId() {
        return id;
    }

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Floor floor;

    @NotEmpty
    @NotNull
    @OneToMany(mappedBy = "workRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "workRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkingTable> workingTables;

    @NotNull
    @NotEmpty
    @JoinColumn(name = "coordinateX", nullable = false)
    private double coordinateX;

    @NotNull
    @NotEmpty
    @JoinColumn(name = "coordinateX", nullable = false)
    private double coordinateY;

    @NotNull
    @NotEmpty
    @JoinColumn(name = "height", nullable = false)
    private double height;

    @NotNull
    @NotEmpty
    @JoinColumn(name = "width", nullable = false)
    private double width;

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

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

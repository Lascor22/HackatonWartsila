package com.blagoy.officemaps.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private List<Door> doors;

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


    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.blagoy.officemaps.form;

import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.domain.Point;

import java.util.List;

public class WorkRoomForm {
    private long number;
    private long floorNumber;
    private Point point;
    private double height;
    private double width;
    private List<Door> doors;
    private List<ObjectMap> neighbors;

    public List<ObjectMap> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<ObjectMap> neighbors) {
        this.neighbors = neighbors;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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
}

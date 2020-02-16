package com.blagoy.officemaps.form;

import com.blagoy.officemaps.domain.Door;
import com.blagoy.officemaps.domain.ObjectMap;
import com.blagoy.officemaps.domain.Point;
import com.blagoy.officemaps.domain.PublicRoomType;

import java.util.List;

public class PublicRoomForm {
    public long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public PublicRoomType getType() {
        return type;
    }

    public void setType(PublicRoomType type) {
        this.type = type;
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

    public List<ObjectMap> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<ObjectMap> neighbors) {
        this.neighbors = neighbors;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    private long floorNumber;
    private PublicRoomType type;
    private double height;
    private double width;
    private List<ObjectMap> neighbors;
    private Point point;
    private List<Door> doors;
}

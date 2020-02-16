package com.blagoy.officemaps.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ObjectMap implements Comparable<ObjectMap> {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ObjectMap> neighbors;

    @OneToMany
    private List<Door> doors;

    @JoinColumn(name = "point", nullable = false)
    @OneToOne
    private Point point;

    @JoinColumn(name = "height", nullable = false)
    private double height;

    @JoinColumn(name = "width", nullable = false)
    private double width;


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

    @Override
    public int compareTo(ObjectMap another) {
        return Long.compare(this.id, another.getId());
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<ObjectMap> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<ObjectMap> neighbors) {
        this.neighbors = neighbors;
    }
}

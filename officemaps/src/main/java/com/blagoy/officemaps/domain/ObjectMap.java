package com.blagoy.officemaps.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    private Floor floor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}

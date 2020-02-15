package com.blagoy.officemaps.domain;

import java.util.List;

public class Floor {

    private long id;

    private long number;

    private List<ObjectMap> objectMaps;

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

    public List<ObjectMap> getObjectMaps() {
        return objectMaps;
    }

    public void setObjectMaps(List<ObjectMap> objectMaps) {
        this.objectMaps = objectMaps;
    }
}

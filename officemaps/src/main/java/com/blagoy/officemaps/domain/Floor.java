package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Floor {
    @Id
    private long id;

    private long number;
    @NotNull
    @NotEmpty
    private List<ObjectMap> objectMaps;

    @CreationTimestamp
    private Date creationTime;

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

package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Floor {
    @Id
    private long id;

    @JoinColumn(name = "number", nullable = false)
    private long number;

    @OneToMany(fetch = FetchType.LAZY)
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}

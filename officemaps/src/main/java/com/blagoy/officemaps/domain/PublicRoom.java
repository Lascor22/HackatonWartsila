package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class PublicRoom {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;

    @NotNull
    @NotEmpty
    @JoinColumn(name = "type", nullable = false)
    private PublicRoomType type;

    @CreationTimestamp
    private Date creationTime;

    public PublicRoomType getType() {
        return type;
    }

    public void setType(PublicRoomType type) {
        this.type = type;
    }

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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}

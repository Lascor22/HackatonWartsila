package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "public_room")
public class PublicRoom extends ObjectMap {

    private long floorNumber;

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

    public long getFloor() {
        return floorNumber;
    }

    public void setFloor(long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

}

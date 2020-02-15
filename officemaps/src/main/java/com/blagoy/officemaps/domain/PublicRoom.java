package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class PublicRoom extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    private Floor floor;

    private PublicRoomType type;

    @CreationTimestamp
    private Date creationTime;

    public PublicRoomType getType() {
        return type;
    }

    public void setType(PublicRoomType type) {
        this.type = type;
    }
}

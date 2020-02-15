package com.blagoy.officemaps.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Document(collection = "PublicRoom")
public class PublicRoom extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    @Field(value = "PublicRoomType")
    private PublicRoomType type;

    public PublicRoomType getType() {
        return type;
    }

    public void setType(PublicRoomType type) {
        this.type = type;
    }
}

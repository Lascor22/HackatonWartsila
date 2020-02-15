package com.blagoy.officemaps.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transition extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    @Field(value = "TransitionType")
    private TransitionType type;

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }
}

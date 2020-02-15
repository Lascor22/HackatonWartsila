package com.blagoy.officemaps.domain;


import javax.persistence.*;

@Entity
@Table
public class Transition extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;
    @JoinColumn(name = "type", nullable = false)
    private TransitionType type;

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }
}

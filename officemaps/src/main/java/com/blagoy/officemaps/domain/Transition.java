package com.blagoy.officemaps.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Transition extends ObjectMap {
    @NotNull
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;

    @JoinColumn(name = "type", nullable = false)
    private TransitionType type;

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }
}

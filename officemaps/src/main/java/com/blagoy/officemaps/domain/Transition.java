package com.blagoy.officemaps.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Transition extends ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    private Floor floor;

    private TransitionType type;

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }
}

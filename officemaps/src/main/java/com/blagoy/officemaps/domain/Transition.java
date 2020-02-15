package com.blagoy.officemaps.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Transition {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;
    @JoinColumn(name = "type", nullable = false)
    private TransitionType type;

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

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

    @NotEmpty
    @NotNull
    @JoinColumn(name = "number", nullable = false)
    private long number;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PublicRoom> publicRooms;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkRoom> workRooms;

    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transition> transitions;

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

    public List<PublicRoom> getPublicRooms() {
        return publicRooms;
    }

    public void setPublicRooms(List<PublicRoom> publicRooms) {
        this.publicRooms = publicRooms;
    }

    public List<WorkRoom> getWorkRooms() {
        return workRooms;
    }

    public void setWorkRooms(List<WorkRoom> workRooms) {
        this.workRooms = workRooms;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }
}

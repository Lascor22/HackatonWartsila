package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Floor {
    @Id
    @GeneratedValue
    private long id;

    @JoinColumn(name = "number", nullable = false)
    private long number;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PublicRoom> publicRooms;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkRoom> workRooms;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transition> transitions;

    @CreationTimestamp
    private Date creationTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

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

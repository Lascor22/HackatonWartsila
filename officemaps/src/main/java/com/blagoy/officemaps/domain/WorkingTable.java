package com.blagoy.officemaps.domain;


import javax.persistence.*;

@Entity
@Table
public class WorkingTable {
    @Id
    @GeneratedValue
    private long id;

    @JoinColumn(name = "number", nullable = false)
    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}

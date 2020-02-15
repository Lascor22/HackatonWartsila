package com.blagoy.officemaps.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Event {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Employee> employeeList;

//    @NotNull
//    @NotEmpty
//    private Object room;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @CreationTimestamp
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

//    public Object getRoom() {
//        return room;
//    }

//    public void setRoom(PublicRoom room) {
//        this.room = room;
//    }
//
//    public void setRoom(WorkRoom room) {
//        this.room = room;
//    }
}

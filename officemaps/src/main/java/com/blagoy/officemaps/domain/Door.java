package com.blagoy.officemaps.domain;

import javax.persistence.*;

@Entity
@Table
public class Door {
    @Id
    @GeneratedValue
    private long id;

    private double leftX;

    private double rightX;

    private double leftY;

    private double rightY;

    public long getId() {
        return id;
    }

    public double getLeftX() {
        return leftX;
    }

    public void setLeftX(double leftX) {
        this.leftX = leftX;
    }

    public double getRightX() {
        return rightX;
    }

    public void setRightX(double rightX) {
        this.rightX = rightX;
    }

    public double getLeftY() {
        return leftY;
    }

    public void setLeftY(double leftY) {
        this.leftY = leftY;
    }

    public double getRightY() {
        return rightY;
    }

    public void setRightY(double rightY) {
        this.rightY = rightY;
    }

    public void setId(long id) {
        this.id = id;
    }
}

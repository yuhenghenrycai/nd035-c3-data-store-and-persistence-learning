package com.yhcai.data_store_and_persistence.data;

import javax.persistence.Entity;

@Entity
public class Flower extends Plant {
    private String color;

    /* getters and setters*/

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
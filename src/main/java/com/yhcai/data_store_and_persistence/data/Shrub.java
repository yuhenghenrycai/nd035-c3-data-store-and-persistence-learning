package com.yhcai.data_store_and_persistence.data;

import javax.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private int heightCm; //any reasonable unit of measurement is fine
    private int widthCm;

    /* getters and setters*/
}

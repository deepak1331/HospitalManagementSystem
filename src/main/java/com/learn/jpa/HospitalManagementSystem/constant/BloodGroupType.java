package com.learn.jpa.HospitalManagementSystem.constant;

import lombok.Data;

public enum BloodGroupType {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String type;

    private BloodGroupType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString(){
        return type;
    }
}
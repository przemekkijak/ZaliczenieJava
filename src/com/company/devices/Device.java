package com.company.devices;


import com.company.Saleable;

public abstract class Device implements Saleable {
    final String producer;
    final String model;
    final int yearOfProduction;
    String colour;

    public Device(String producer, String model, int yearOfProduction, String colour) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.colour = colour;
    }

    public abstract void turnOn();

    public abstract boolean isTurnedOn();

}
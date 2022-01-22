package com.company.devices;


import com.company.Saleable;

public abstract class Device implements Saleable {
    final String producer;
    final String model;
    final int yearOfProduction;
    String colour;
    public Double value;

    public Device(String producer, String model, int yearOfProduction, String colour, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.colour = colour;
        this.value = value;
    }

    public abstract void turnOn();

    public abstract boolean isTurnedOn();

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
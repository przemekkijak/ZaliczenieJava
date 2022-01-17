package com.company.Devices;

import com.company.Human;

public class Car extends Device {
    Double engineVolume;

    public Car(String producer, String model, int yearOfProduction, String colour, Double engineVolume) {
        super(producer, model, yearOfProduction, colour);
        this.engineVolume = engineVolume;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public boolean isTurnedOn() {
        return false;
    }

    @Override
    public void sale(Human seller, Human buyer, Double price) {

    }
}
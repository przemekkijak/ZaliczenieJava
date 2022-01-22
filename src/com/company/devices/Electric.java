package com.company.devices;

public class Electric extends Car {
    public Electric(String producer, String model, int yearOfProduction, String colour, Double engineVolume, Double value) {
        super(producer, model, yearOfProduction, colour, engineVolume, value);
    }

    @Override
    public void refuel() {

    }
}

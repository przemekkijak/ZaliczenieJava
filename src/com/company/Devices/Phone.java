package com.company.Devices;


import com.company.Human;

public class Phone extends Device {
    final int ram;
    int totalStorage;

    public Phone(String producer, String model, int yearOfProduction, String colour, int ram, int totalStorage) {
        super(producer, model, yearOfProduction, colour);
        this.ram = ram;
        this.totalStorage = totalStorage;
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
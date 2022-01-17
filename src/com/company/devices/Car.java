package com.company.devices;

import com.company.Human;

public class Car extends Device {
    Double engineVolume;
    public Double value;

    public Car(String producer, String model, int yearOfProduction, String colour, Double engineVolume, Double value) {
        super(producer, model, yearOfProduction, colour);
        this.engineVolume = engineVolume;
        this.value = value;
    }

    @Override
    public void turnOn() {
        System.out.println("Silnik w aucie włączony");
    }

    @Override
    public boolean isTurnedOn() {
        return false;
    }

    @Override
    public void sale(Human seller, Human buyer, Double price) {
    }

    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", colour='" + colour + '\'' +
                ", engineVolume=" + engineVolume +
                ", value=" + value +
                '}';
    }
}
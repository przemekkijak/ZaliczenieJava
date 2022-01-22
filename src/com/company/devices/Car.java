package com.company.devices;

import com.company.creatures.Human;

public abstract class Car extends Device {
    Double engineVolume;

    public Car(String producer, String model, int yearOfProduction, String colour, Double engineVolume, Double value) {
        super(producer, model, yearOfProduction, colour, value);
        this.engineVolume = engineVolume;
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

        var sellerCarSlot = seller.CheckIfHaveCar(this);
        if (sellerCarSlot < 0) {
            System.out.println("Nie mozesz sprzedac auta ktorego nie posiadasz");
            return;
        }

        if(buyer.cash < price) {
            System.out.println("Kupujacy ma za mało gotowki");
            return;
        }

        var buyerFreeSlot = buyer.CheckIfHaveFreeSlot();
        if (buyerFreeSlot < 0) {
            System.out.println("Kupujacy nie ma wolnych miejsc w garazu");
            return;
        }

        seller.setCar(null, sellerCarSlot);
        buyer.setCar(this, buyerFreeSlot);

        buyer.cash += price;
        seller.cash -= price;

        System.out.println(seller.firstName + " sprzedal samochod uzytkownikowi " + buyer.firstName);
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

    public abstract void refuel();


}
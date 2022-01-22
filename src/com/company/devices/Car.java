package com.company.devices;

import com.company.creatures.Human;

import java.util.ArrayList;

public abstract class Car extends Device {
    Double engineVolume;
    public ArrayList<Human> previousOwners = new ArrayList<>();

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

        if (this.previousOwners.size() > 0) {
            if (this.previousOwners.get(this.previousOwners.size() - 1) != buyer) {
                System.out.println("Sprzedajacy nie jest wlascicielem pojazdu");
            }
        }

        seller.setCar(null, sellerCarSlot);
        buyer.setCar(this, buyerFreeSlot);

        buyer.cash -= price;
        seller.cash += price;

        System.out.println(seller.firstName + " sprzedal samochod uzytkownikowi " + buyer.firstName);
        this.previousOwners.add(buyer);
    }

    public boolean checkIfUserHadThisCar(Human human) {
        for(int i = 0; i<previousOwners.size(); i++) {
            if (previousOwners.get(i) == human) {
                System.out.println("User had this car before");
                return true;
            }
        }

        return false;
    }

    public boolean checkIfTransactionsWasMade(Human a, Human b) {
        for (int i = 0; i<previousOwners.size(); i++) {
            if (previousOwners.get(i) == a && previousOwners.get(i+1) == b) {
                System.out.println("Transaction was made between two of them");
                return true;
            }
        }

        return false;
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
package com.company.devices;

import com.company.creatures.Human;
import java.net.URL;
import java.util.List;

public class Phone extends Device {
    final int ram;
    int totalStorage;
    static final URL defaultAppServer = null;

    public Phone(String producer, String model, int yearOfProduction, String colour, int ram, int totalStorage, Double value) {
        super(producer, model, yearOfProduction, colour, value);
        this.ram = ram;
        this.totalStorage = totalStorage;
    }

    @Override
    public void turnOn() {
        System.out.println("Telefon włączony");
    }

    @Override
    public boolean isTurnedOn() {
        return false;
    }

    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", ram='" + ram + '\'' +
                ", totalStorage=" + totalStorage +
                '}';
    }

    @Override
    public void sale(Human seller, Human buyer, Double price) {

        if(!(seller.phone == this)) {
            System.out.println("Nie mozesz sprzedac telefonu ktorego nie posiadasz");
            return;
        }

        if(buyer.cash < price) {
            System.out.println("Kupujacy ma za mało gotowki");
            return;
        }

        seller.phone = null;
        buyer.phone = this;

        buyer.cash += price;
        seller.cash -= price;

        System.out.println(seller.firstName + " sprzedal telefon uzytkownikowi " + buyer.firstName);
    }


    public void InstallAnnApp(String appName) {
    }

    public void InstallAnnApp(String appName, double version) {
    }

    public void InstallAnnApp(String appName, String serverUrl) {
    }

    public void InstallAnnApp(List<String> appNames) {
    }

    public void InstallAnnApp(URL appObject) {
    }
}
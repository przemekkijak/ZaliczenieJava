package com.company.devices;

import com.company.Application;
import com.company.creatures.Human;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Phone extends Device {
    final int ram;
    int totalStorage;
    static final URL defaultAppServer = null;
    ArrayList<Application> apps = new ArrayList<>();

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


    public void installAnnApp(String appName) {
    }

    public void installAnnApp(String appName, double version) {
    }

    public void installAnnApp(String appName, String serverUrl) {
    }

    public void installAnnApp(List<String> appNames) {
        for(String name : appNames) {
           installAnnApp(name);
        }
    }

    public void installAnnApp(URL appObject) {
    }

    public void installAnnApp(Application app, Human owner) {

        if (owner.phone != this) {
            System.out.println("This is not your phone, I am calling 911");
            return;
        }

        System.out.println("Owner cash: " + owner.cash + ", app price: " + app.price);
        if (owner.cash < app.price) {
            System.out.println("Nope, nie mozesz sobiee na to pozwolic, idz do pracy");
            return;
        }

        this.apps.add(app);
        owner.cash -= app.price;
        System.out.println("Apka " + app.appName + " zainstalowana");
    }

    public boolean isAppInstalled(Application app) {
        for(Application a : apps) {
            if (a == app) {
                System.out.println("Apka jest zainstalowana na telefonie");
                return true;
            }
        }

        return false;
    }

    public boolean isAppInstalled(String appName) {
        for(Application a : apps) {
            if (a.appName == appName) {
                System.out.println("Apka jest zainstalowana na telefonie");
                return true;
            }
        }

        return false;
    }

    public void getFreeAppsInstalled() {
        System.out.println("Darmowe apki na Twoim telefonie:");
        for(Application a : apps) {
            if (a.price <= 0.0) {
                System.out.println(a.appName);
            }
        }
    }

    public double getAppsValue() {
        var result = 0.0;
        for(Application a : apps) {
            result += a.price;
        }

        System.out.println(result);
        return result;
    }

    public ArrayList<Application> getAppsAlphabetical() {
        var list = new ArrayList<Application>(apps);
        Collections.sort(list, Comparator.comparing(a -> a.appName));

        for(Application a : list) {
            System.out.println(a.appName);
        }

        return list;
    }

    public ArrayList<Application> getAppsByPrice() {
        var list = new ArrayList<Application>(apps);
        Collections.sort(list, Comparator.comparing(a -> a.price));

        for(Application a : list) {
            System.out.println(a.price);
        }

        return list;
    }

}
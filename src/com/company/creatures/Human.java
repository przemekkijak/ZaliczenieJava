package com.company.creatures;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.Date;

public class Human extends Animal {

    public String firstName;
    public String lastName;
    public Double cash;
    public Animal animal;
    public Phone phone;
    public Car[] garage;
    private Double salary;
    private Double lastTimeSalary;
    private Date lastTimeSalaryCheck;
    private int defaultGarageSize = 3;

    public Human(String firstName, String lastName, Double cash) {
        super("homo sapiens", false, 2, true);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.garage = new Car[defaultGarageSize];
    }

    public Human(String firstName, String lastName, Double cash, int garageSize) {
        super("homoe sapiens", false, 2, true);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.garage = new Car[garageSize];
    }

    public Double getSalary() {
        System.out.println("Ostatni raz wyplate sprawdzales " + lastTimeSalaryCheck.toString() + ", wynosila ona " + lastTimeSalary);
        lastTimeSalary = salary;
        lastTimeSalaryCheck = new Date();
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Nie możesz przypisac wypłaty mniejszej od 0, to niemoralne nawet jak na polske");
            return;
        }

//        System.out.println("Ksiegowa dostała potwierdzenie że od następnego miesiąca zarabiasz więcej");
//        System.out.println("U Pani Halinki papiery do podpisania, na wczoraj");
//        System.out.println("ZUS już wszystko wie ;)");
        this.salary = salary;
    }

    public Car getCar(int slot) {
        if (slot >= garage.length) {
            System.out.println("Nie masz tylu miejsc w garażu");
        }

        if (slot < 0) {
            System.out.println("Co probujesz osiągnąć?");

        }

        return garage[slot];
    }

    public void setCar(Car car, int slot) {

        if (slot >= garage.length || slot < 0) {
            System.out.println("Problem z miejscem garazowym, sprobuj ponownie pozniej");
            return;
        }

        if (this.garage[slot] != null && car != null) {
            System.out.println("W tym miejscu już stoi samochód, wybierz inne miejsce lub sprzedaj go");
        }

        if (car == null) {
            this.garage[slot] = null;
            return;
        }

        if (this.salary > car.value) {
            System.out.println("Nie wiem jak to zrobiłeś, ale stać cie na tą furę! Kupiona za gotówkę");
            this.garage[slot] = car;
            car.previousOwners.add(this);
            return;
        }

        if (this.salary > (car.value / 12)) {
            System.out.println("Szału nie ma, ale kredyt jest, kupione");
            this.garage[slot] = car;
            return;
        }

        System.out.println("Bieda w kraju, nie stać cie na fure. Zapraszam na wsb");
        return;
    }

    public int CheckIfHaveCar(Car car) {
        for(int i = 0; i<garage.length; i++) {
            if(garage[i] == car) {
                return i;
            }
        }

        return -1;
    }

    public int CheckIfHaveFreeSlot() {
        for(int i = 0; i<garage.length; i++) {
            if(garage[i] == null) {
                return i;
            }
        }

        return -1;
    }

    public Double getGarageValue() {
        double sum = 0.0;
        for(Car c : garage) {
            sum += c.value;
        }

        return sum;
    }

    public void sortCarsByProdYear() {
        for(int i = 0; i<garage.length-1; i++) {
            if (garage[i] != null && garage[i+1] != null) {
                var a = garage[i];
                var b = garage[i+1];

                if(a.getYearOfProduction() > b.getYearOfProduction()) {
                    garage[i] = b;
                    garage[i+1] = a;
                }
            }
        }
    }


    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cash=" + cash +
                '}';
    }

    @Override
    public void feed(double foodWeight) {

    }
}

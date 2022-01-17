package com.company;

import com.company.Devices.Car;
import com.company.Devices.Phone;

import java.util.Date;

public class Human extends Animal {

    public String firstName;
    public String lastName;
    public Double cash;
    public Animal animal;
    public Phone phone;
    private Car car;
    private Double salary;
    private Double lastTimeSalary;
    private Date lastTimeSalaryCheck;

    public Human(String firstName, String lastName, Double cash) {
        super("homo sapiens", false, 2, true);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
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

        System.out.println("Ksiegowa dostała potwierdzenie że od następnego miesiąca zarabiasz więcej");
        System.out.println("U Pani Halinki papiery do podpisania, na wczoraj");
        System.out.println("ZUS już wszystko wie ;)");
        this.salary = salary;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (this.salary > car.value) {
            System.out.println("Nie wiem jak to zrobiłeś, ale stać cie na tą furę! Kupiona za gotówkę");
            this.car = car;
            return;
        }

        if (this.salary > (car.value / 12)) {
            System.out.println("Szału nie ma, ale kredyt jest, kupione");
            this.car = car;
            return;
        }

        System.out.println("Bieda w kraju, nie stać cie na fure. Zapraszam na wsb");
        return;
    }
}

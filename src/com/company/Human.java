package com.company;

import com.company.Devices.Car;
import com.company.Devices.Phone;

public class Human extends Animal {

    public String firstName;
    public String lastName;
    public Double cash;
    public Animal animal;
    public Phone phone;
    public Car car;
    private Double salary;

    public Human(String firstName, String lastName, Double cash) {
        super("homo sapiens", false, 2, true, 60.0);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }

}

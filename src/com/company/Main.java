package com.company;

import com.company.Devices.Car;
import com.company.Devices.Phone;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Animal("Burek", true, 3, true);
        Animal cat = new Animal("Marek", false, 7, true);

        Car firstCar = new Car("Porshe", "911", 2004, "Black", 3.0);
        Phone firstPhone = new Phone("Apple", "iPhone 11" , 2020, "black", 8, 64);

        Human human1 = new Human("Przemek", "Kijak", 5000.0);
        Human human2 = new Human("Tom", "Kowalski", 3000.0);

        human1.animal = dog;
        human1.car = firstCar;

        //Test wyprowadzania martwego kota na spacer
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
        cat.takeForAWalk();
    }
}

package com.company;

import com.company.creatures.Animal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.*;

public class Main {

    public static void main(String[] args) {

//        Animal dog = new Pet("Burek", true, 3, true);
//        Animal cat = new Pet("Marek", false, 7, true);

        Car firstCar = new Electric("Porshe", "911", 2004, "Black", 3.0, 42000.0);
        Car secondCar = new LPG("Porshe", "911", 2004, "Black", 3.0, 42000.0);

        Phone firstPhone = new Phone("Apple", "iPhone 11" , 2020, "black", 8, 64, 3200.0);

        Human human1 = new Human("Przemek", "Kijak", 5000.0);
        Human human2 = new Human("Tom", "Kowalski", 3000.0);

        human1.setSalary(50000.0);
        human1.setCar(firstCar, 0);

        human2.setSalary(35000.0);
        human2.cash = 50000.0;

        System.out.println("Sprzedawanie auta");
        firstCar.sale(human1, human2, 15000.0);
        human1.sale(human1, human2, 5.0);

        firstCar.checkIfUserHadThisCar(human1);
        firstCar.checkIfTransactionsWasMade(human1, human2);
    }
}

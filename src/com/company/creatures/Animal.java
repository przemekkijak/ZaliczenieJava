package com.company.creatures;

import com.company.Saleable;

public abstract class Animal implements Saleable, Feedable {

    final private String species;
    private boolean canFly;
    private int legs;
    private boolean isAlive;
    private double weight;


    public Animal(String species, boolean canFly, int legs, boolean isAlive) {
        this.species = species;
        this.canFly = canFly;
        this.legs = legs;
        this.isAlive = isAlive;

        switch(species) {
            case "homo sapiens":
                this.weight = 60.0;
                break;
            case "dog":
                this.weight = 20.0;
                break;
            case "cat":
                this.weight = 8.0;
                break;
            default:
                this.weight = 5.0;
                break;
        }
    }

    public void feed() {
        if (this.isAlive) {
            this.weight += 1.0;
            System.out.println("Zwierz nakarmiony");
        } else {
            System.out.println("To troche niemoralne karmić martwego zwierzaka");
        }
    }

    public void takeForAWalk() {
        if (this.isAlive) {
            this.weight -= 1.0;
            System.out.println("Zwierz wyprowadzony");
        } else {
            System.out.println("Próba wyprowadzenia martwego zwierzaka na spacer zakończona niepowodzeniem, spróbuj ponownie z żywym");
        }

        if (this.weight <= 0.0 && this.isAlive) {
            this.isAlive = false;
            System.out.println("Gratulacje, zabiłes zwierzaka! +5xp");
        }
    }

    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", canFly='" + canFly + '\'' +
                ", legs=" + legs +
                '}';
    }

    @Override
    public void sale(Human seller, Human buyer, Double price) {
        if(this instanceof Human) {
            System.out.println("Handel ludzmi póki co jest nielegalny, coming soon");
            return;
        }

        if(!(seller.animal == this)) {
            System.out.println("Nie mozesz sprzedac zwierzaka ktorego nie posiadasz");
            return;
        }

        if(buyer.cash < price) {
            System.out.println("Kupujacy ma za mało gotowki");
            return;
        }

        seller.animal = null;
        buyer.animal = this;

        buyer.cash += price;
        seller.cash -= price;

        System.out.println(seller.firstName + " sprzedal zwierze uzytkownikowi " + buyer.firstName);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAlive() {
        return isAlive;
    }
}

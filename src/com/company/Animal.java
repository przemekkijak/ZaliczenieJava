package com.company;

public class Animal {

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

}

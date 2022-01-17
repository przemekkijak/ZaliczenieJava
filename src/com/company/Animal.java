package com.company;

public class Animal {

    private String species;
    private boolean canFly;
    private int legs;
    private boolean isAlive;
    private double weight;


    public Animal(String species, boolean canFly, int legs, boolean isAlive, double weight) {
        this.species = species;
        this.canFly = canFly;
        this.legs = legs;
        this.isAlive = isAlive;
        this.weight = weight;
    }
}

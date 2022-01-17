package com.company.creatures;

public class Pet extends Animal implements Edible {

    public Pet(String species, boolean canFly, int legs, boolean isAlive) {
        super(species, canFly, legs, isAlive);
    }

    @Override
    public void beEaten() {

    }

    @Override
    public void feed(double foodWeight) {
        if(this.isAlive()) {
            this.setWeight(this.getWeight() + foodWeight);
        }
    }
}

package com.company.creatures;

public class FarmAnimal extends Animal implements Edible {


    public FarmAnimal(String species, boolean canFly, int legs, boolean isAlive) {
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

package com.company;

import com.company.creatures.Human;

public interface Saleable {
    void sale(Human seller, Human buyer, Double price);
}
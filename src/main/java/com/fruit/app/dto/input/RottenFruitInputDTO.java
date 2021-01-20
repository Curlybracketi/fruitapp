package com.fruit.app.dto.input;

import com.fruit.app.models.RottenFruit;

import java.util.List;

public class RottenFruitInputDTO {
    List<RottenFruit> fruits;

    public List<RottenFruit> getFruits() {
        return fruits;
    }

    public void setFruit(List<RottenFruit> fruit) {
        this.fruits = fruit;
    }
}

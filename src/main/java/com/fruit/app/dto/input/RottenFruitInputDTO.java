package com.fruit.app.dto.input;

import com.fruit.app.models.extras.RottenFruit;

import java.util.List;

public class RottenFruitInputDTO {
    List<RottenFruit> fruitCartForms;

    public List<RottenFruit> getFruitCartForms() {
        return fruitCartForms;
    }

    public void setFruitCartForms(List<RottenFruit> fruitCartForms) {
        this.fruitCartForms = fruitCartForms;
    }
}

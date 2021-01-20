package com.fruit.app.dto.output;

import com.fruit.app.dto.enums.Status;
import com.fruit.app.models.Fruit;

public class  FruitResponseDTO extends StandardResponseDTO {
    private Fruit fruit;

    public FruitResponseDTO(Status status) {
        super(status);
    }

    public FruitResponseDTO(Status status, Fruit fruit) {
        super(status);
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}

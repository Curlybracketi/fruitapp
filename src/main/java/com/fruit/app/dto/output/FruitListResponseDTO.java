package com.fruit.app.dto.output;

import com.fruit.app.dto.enums.Status;
import com.fruit.app.models.Fruit;

import java.util.List;

public class FruitListResponseDTO extends  StandardResponseDTO {
    List<Fruit> fruitList;

    public FruitListResponseDTO(Status status, List<Fruit> fruitList) {
        super(status);
        this.fruitList = fruitList;
    }

    public FruitListResponseDTO(Status status) {
        super(status);
    }

    public FruitListResponseDTO() {
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
}

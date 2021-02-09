package com.fruit.app.dto.output;

import com.fruit.app.dto.enums.Status;
import com.fruit.app.models.FruitCart;

public class FruitCartResponseDTO extends  StandardResponseDTO {
    FruitCart fruitCart;

    public FruitCartResponseDTO() {
    }

    public FruitCartResponseDTO(Status status) {
        super(status);
    }

    public FruitCartResponseDTO(Status status, FruitCart fruitCart) {
        super(status);
        this.fruitCart = fruitCart;
    }

    public FruitCart getFruitCart() {
        return fruitCart;
    }

    public void setFruitCart(FruitCart fruitCart) {
        this.fruitCart = fruitCart;
    }

}

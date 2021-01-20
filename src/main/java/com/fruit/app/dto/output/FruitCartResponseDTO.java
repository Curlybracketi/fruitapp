package com.fruit.app.dto.output;

import com.fruit.app.dto.enums.Status;
import com.fruit.app.models.FruitCart;

public class FruitCartResponseDTO extends  StandardResponseDTO {
    FruitCart fruitcart;

    public FruitCartResponseDTO() {
    }

    public FruitCartResponseDTO(Status status) {
        super(status);
    }

    public FruitCartResponseDTO(Status status, FruitCart fruitcart) {
        super(status);
        this.fruitcart = fruitcart;
    }

    public FruitCart getFruitCart() {
        return fruitcart;
    }

    public void setAttendance(FruitCart fruitcart) {
        this.fruitcart = fruitcart;
    }

}

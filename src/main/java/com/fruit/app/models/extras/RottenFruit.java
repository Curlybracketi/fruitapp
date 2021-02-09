package com.fruit.app.models.extras;

public class RottenFruit {
    private String fruitId;

    private boolean FruitStatus;

    public String getFruitId() {
        return fruitId;
    }

    public void setFruit(String fruitId) {
        this.fruitId = fruitId;
    }

    public boolean isRotten() {
        return FruitStatus;
    }

    public void setFruit(boolean fruitStatus) {
        this.FruitStatus = fruitStatus;
    }
}

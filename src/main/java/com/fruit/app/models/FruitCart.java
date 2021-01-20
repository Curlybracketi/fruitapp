package com.fruit.app.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class FruitCart {
    @Id
    private String id;

    private Date date;

    private List<Fruit> totalFruits;

    private List<Fruit> soldFruits;

    private int numberOfTotalFruits;

    private int numberOfSoldFruits;

    public FruitCart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Fruit> getTotalFruits() {
        return totalFruits;
    }

    public void setTotalFruits(List<Fruit> totalFruits) {
        this.totalFruits = totalFruits;
    }

    public List<Fruit> getSoldFruits() { return soldFruits; }

    public void setSoldFruits(List<Fruit> soldFruits) {
        this.soldFruits = soldFruits;
    }

    public int getNumberOfTotalFruits() {
        return numberOfTotalFruits;
    }

    public void setNumberOfTotalFruits(int numberOfTotalFruits) {
        this.numberOfTotalFruits = numberOfTotalFruits;
    }

    public int getNumberOfSoldFruits() {
        return numberOfSoldFruits;
    }

    public void setNumberOfSoldFruits(int numberOfSoldFruits) { this.numberOfSoldFruits = numberOfSoldFruits; }
}

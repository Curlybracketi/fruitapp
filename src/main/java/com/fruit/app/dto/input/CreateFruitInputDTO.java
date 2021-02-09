package com.fruit.app.dto.input;


import org.jetbrains.annotations.NotNull;

public class CreateFruitInputDTO {

    @NotNull
private String name;
    @NotNull
private String type;



    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;
    }

    public String getType(){ return type; }

    public void setType(String type) {
        this.type = type;
    }
}

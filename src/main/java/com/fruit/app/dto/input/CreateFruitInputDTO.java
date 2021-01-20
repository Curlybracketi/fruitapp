package com.fruit.app.dto.input;


import org.jetbrains.annotations.NotNull;

public class CreateFruitInputDTO {
    @NotNull
private String Id;
    @NotNull
private String name;
private String size;
private String type;

    public String getId() {
        return Id;
    }

    public void setId(String id) { this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType(){ return type; }

    public void setType(String type) {
        this.type = type;
    }
}

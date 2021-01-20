package com.fruit.app.models;

import org.springframework.data.annotation.Id;

public class Fruit {
    @Id
    private String _id;
    private String name;
    private String size;
    private String type;
public Fruit(String name, String size, String type)
    {
        this.name = name;
        this.size = size;
        this.type = type;
    }
    public Fruit(){
    }
    private String get_id(){ return _id;}
    private void set_id(String _id){this._id = _id;}

    private  String getName(){return name;}
    private void setName(String name){this.name = name;}

    private String getSize(){ return size;}
    private void setSize(String size){ this.size = size;}

    private String getType(){ return type;}
    private  void setType(String type){this.type = type;}
}

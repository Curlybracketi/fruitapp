package com.fruit.app.models;

import org.springframework.data.annotation.Id;

public class Fruit {
    @Id
    private String _id;
    private String name;
    private String type;


public Fruit(String name,
             String type)
    {
        this.name = name;
        this.type = type;
    }

    public Fruit() {
    }

    private String get_id(){
    return _id;}

    private void set_id(String _id)
    {this._id = _id;}

    private  String getName()
    {return name;}

    private void setName(String name)
    {this.name = name;}


    private String getType()
    { return type;}

    private  void setType(String type)
    {this.type = type;}
}

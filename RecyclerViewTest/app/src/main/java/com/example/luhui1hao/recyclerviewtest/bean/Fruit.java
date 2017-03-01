package com.example.luhui1hao.recyclerviewtest.bean;

/**
 * Created by luhui on 2017/2/11.
 */

public class Fruit {
    private int id;

    private String name;

    private String color;

    public Fruit(int id, String name, String color){
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

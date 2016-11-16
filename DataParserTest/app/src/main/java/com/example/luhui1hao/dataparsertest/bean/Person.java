package com.example.luhui1hao.dataparsertest.bean;

/**
 * Created by luhui on 2016/7/26.
 */
public class Person {
    private int id;
    private String name;
    private int age;
    private int number;
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "id=" + getId() + ";" + "name=" + getName() + ";" +
                "age=" + getAge() + ";" + "number=" + getNumber() + ";" +
                "position=" + getPosition() + "\n\n";
    }
}

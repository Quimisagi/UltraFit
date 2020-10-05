package com.example.ultrafit;

import java.io.Serializable;


public class User implements Serializable {

    static User instance;

    String name;
    int age;
    int stature;
    int weight;
    int objective;

    public User(String name, int age, int stature, int weight, int objective) {
        this.name = name;
        this.age = age;
        this.stature = stature;
        this.weight = weight;
        this.objective = objective;
    }

    public int getObjective() {
        return objective;
    }

    public void setObjective(int objective) {
        this.objective = objective;
    }

    public static User getInstance(){
        if(instance == null){
            instance = new User("", 0, 0, 0, 0);
        }
        return instance;
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

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

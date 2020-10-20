package com.example.ultrafit;

import java.io.Serializable;

public class DateRecord implements Serializable {
    int time;
    float calories;

    public DateRecord(int time, float calories) {
        this.time = time;
        this.calories = calories;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }
}

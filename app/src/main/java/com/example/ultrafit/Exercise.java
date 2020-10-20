package com.example.ultrafit;

import java.io.Serializable;

public class Exercise implements Serializable {
    String name;
    String videoURL;
    boolean hasLimitTime;
    int time;
    int repetitions;
    float calories;

    public Exercise(String name, String videoURL, boolean hasLimitTime, int time, int repetitions, float calories) {
        this.name = name;
        this.videoURL = videoURL;
        this.hasLimitTime = hasLimitTime;
        this.time = time;
        this.repetitions = repetitions;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public boolean isHasLimitTime() {
        return hasLimitTime;
    }

    public void setHasLimitTime(boolean hasLimitTime) {
        this.hasLimitTime = hasLimitTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }
}

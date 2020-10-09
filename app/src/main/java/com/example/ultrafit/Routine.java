package com.example.ultrafit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Routine implements Serializable {
    String name;
    List<Exercise> exerciseLists = new ArrayList<>();

    public Routine(String name, List<Exercise> exerciseLists) {
        this.name = name;
        this.exerciseLists = exerciseLists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExerciseLists() {
        return exerciseLists;
    }
    
    public void addExercise(Exercise exercise){
        exerciseLists.add(exercise);
    }
}

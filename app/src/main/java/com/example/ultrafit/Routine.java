package com.example.ultrafit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Routine implements Serializable {
    String name;
    String resourceId;
    List<Exercise> exerciseLists = new ArrayList<>();

    public Routine(String name, String resourceId, List<Exercise> exerciseLists) {
        this.name = name;
        this.resourceId = resourceId;
        this.exerciseLists = exerciseLists;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

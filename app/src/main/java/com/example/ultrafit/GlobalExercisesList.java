package com.example.ultrafit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class GlobalExercisesList {
    static GlobalExercisesList instance;

    Hashtable<String, Exercise> exercisesHash =  new Hashtable<String, Exercise>();
    private GlobalExercisesList(){
            createExercises();
    }

    public static Hashtable<String, Exercise> getInstance(){
        if(instance == null){
            instance = new GlobalExercisesList();
        }
        return instance.exercisesHash;
    }

    public void createExercises(){
        Exercise lagartijas = new Exercise("Lagartijas", "", false, 0, 10);
        exercisesHash.put("Lagartijas", lagartijas);
        Exercise sentadillas = new Exercise("Sentadillas", "", false, 0, 10);
        exercisesHash.put("Sentadillas", sentadillas);
        Exercise quesadillas = new Exercise("Quesadillas", "", false, 0, 10);
        exercisesHash.put("Quesadillas", quesadillas);
        Exercise flexiones = new Exercise("Flexiones", "", false, 0, 10);
        exercisesHash.put("Flexiones", flexiones);
    }

}

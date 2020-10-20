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
        Exercise lagartijas = new Exercise("Lagartijas", "push", false, 0, 10, 5);
        exercisesHash.put("Lagartijas", lagartijas);
        Exercise sentadillas = new Exercise("Sentadillas", "air_squat", false, 0, 20, 2.1F);
        exercisesHash.put("Sentadillas", sentadillas);
        Exercise saltoEstrella = new Exercise("Salto de estrella", "push", true, 120, 0, 1.1F);
        exercisesHash.put("Saltoestrella", saltoEstrella);
        Exercise flexiones = new Exercise("Flexiones", "abdominales", false, 0, 15, 2.2F);
        exercisesHash.put("Flexiones", flexiones);
        Exercise plancha = new Exercise("Plancha", "plank", true, 80, 0, 1.2F);
        exercisesHash.put("Plancha", plancha);
        Exercise abdominales = new Exercise("Abdominales", "abdominales", false, 0, 12, 2);
        exercisesHash.put("Abdominales", abdominales);
        Exercise mountainClimber = new Exercise("Mountain Climber", "air_squat", false, 0, 15, 1.9F);
        exercisesHash.put("Mountain", mountainClimber);
    }

}

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
        Exercise lagartijas = new Exercise("Lagartijas", "exercises", false, 0, 10);
        exercisesHash.put("Lagartijas", lagartijas);
        Exercise sentadillas = new Exercise("Sentadillas", "exercises", false, 0, 20);
        exercisesHash.put("Sentadillas", sentadillas);
        Exercise quesadillas = new Exercise("Salto de estrella", "exercises", true, 120, 0);
        exercisesHash.put("Quesadillas", quesadillas);
        Exercise flexiones = new Exercise("Flexiones", "exercises", false, 0, 15);
        exercisesHash.put("Flexiones", flexiones);
        Exercise plancha = new Exercise("Plancha", "exercises", true, 80, 0);
        exercisesHash.put("Plancha", plancha);
        Exercise abdominales = new Exercise("Abdominales", "exercises", false, 0, 12);
        exercisesHash.put("Abdominales", abdominales);
        Exercise mountainClimber = new Exercise("Mountain Climber", "exercises", false, 0, 15);
        exercisesHash.put("Mountain", quesadillas);
    }

}

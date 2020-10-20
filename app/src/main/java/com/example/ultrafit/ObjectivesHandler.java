package com.example.ultrafit;

import java.util.ArrayList;
import java.util.List;

public class ObjectivesHandler {
    static ObjectivesHandler instance;

    List<Routine> adelgazarObjective = new ArrayList<Routine>();
    List<Routine> tonificarObjective = new ArrayList<Routine>();

    private ObjectivesHandler() {
        createPiernasRoutine();
        createAbdomenRoutine();
        createCardioRoutine();
        createAeróbicosRoutine();
    }

    public List<Routine> getAdelgazarObjective() {
        return adelgazarObjective;
    }

    public void setAdelgazarObjective(List<Routine> adelgazarObjective) {
        this.adelgazarObjective = adelgazarObjective;
    }

    public List<Routine> getTonificarObjective() {
        return tonificarObjective;
    }

    public void setTonificarObjective(List<Routine> tonificarObjective) {
        this.tonificarObjective = tonificarObjective;
    }

    public static ObjectivesHandler getInstance(){
        if(instance == null){
            instance = new ObjectivesHandler();
        }
        return instance;
    }

    public void createPiernasRoutine(){
        Routine piernas = new Routine("Pierna", "pierna", new ArrayList<Exercise>());
        piernas.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        piernas.addExercise(GlobalExercisesList.getInstance().get("Saltoestrella"));
        piernas.addExercise(GlobalExercisesList.getInstance().get("Flexiones"));
        piernas.addExercise(GlobalExercisesList.getInstance().get("Plancha"));
        tonificarObjective.add(piernas);
    }

    public void createAbdomenRoutine(){
        Routine abdomen = new Routine("Brazo", "brazo", new ArrayList<Exercise>());
        abdomen.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        abdomen.addExercise(GlobalExercisesList.getInstance().get("Flexiones"));
        abdomen.addExercise(GlobalExercisesList.getInstance().get("Plancha"));
        abdomen.addExercise(GlobalExercisesList.getInstance().get("Abdominales"));

        tonificarObjective.add(abdomen);
    }

    public void createCardioRoutine(){
        Routine bicicleta = new Routine("Cardio", "botoncardio", new ArrayList<Exercise>());
        bicicleta.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        bicicleta.addExercise(GlobalExercisesList.getInstance().get("Mountain"));
        adelgazarObjective.add(bicicleta);
    }

    public void createAeróbicosRoutine(){
        Routine bicicleta = new Routine("Aeróbicos", "aerobicos", new ArrayList<Exercise>());
        bicicleta.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        bicicleta.addExercise(GlobalExercisesList.getInstance().get("Mountain"));
        adelgazarObjective.add(bicicleta);
    }
}

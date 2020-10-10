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
        Routine piernas = new Routine("Piernas", new ArrayList<Exercise>());
        piernas.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        piernas.addExercise(GlobalExercisesList.getInstance().get("Quesadillas"));
        piernas.addExercise(GlobalExercisesList.getInstance().get("Flexiones"));
        tonificarObjective.add(piernas);
    }

    public void createAbdomenRoutine(){
        Routine lagartijas = new Routine("Abdomen", new ArrayList<Exercise>());
        lagartijas.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        lagartijas.addExercise(GlobalExercisesList.getInstance().get("Flexiones"));
        tonificarObjective.add(lagartijas);
    }

    public void createCardioRoutine(){
        Routine bicicleta = new Routine("Bicicleta", new ArrayList<Exercise>());
        bicicleta.addExercise(GlobalExercisesList.getInstance().get("Lagartijas"));
        adelgazarObjective.add(bicicleta);
    }
}

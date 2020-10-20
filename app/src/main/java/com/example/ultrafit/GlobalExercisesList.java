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
        Exercise lagartijas = new Exercise("Lagartijas", "push", false, 0, 10, 5, "Acuéstese boca abajo.\n" +
                "Coloque las palmas de las manos en el suelo a la altura de los hombros, ligeramente más abiertos que el ancho de sus hombros.\n" +
                "Mantenga su cuerpo erguido.\n" +
                "Levante el cuerpo hacia arriba e ir enderezando los brazos, procura mantener una postura erguida.");
        exercisesHash.put("Lagartijas", lagartijas);
        Exercise sentadillas = new Exercise("Sentadillas", "air_squat", false, 0, 20, 2.1F, "Una sentadilla es un ejercicio físico que se lleva a cabo para desarrollar los músculos y fortalecer los tendones y los ligamentos de las piernas. ...\n" +
                "El ejercicio consiste en flexionar las rodillas y bajar el cuerpo manteniendo la verticalidad, para luego regresar a una posición erguida.");
        exercisesHash.put("Sentadillas", sentadillas);
        Exercise saltoEstrella = new Exercise("Salto de estrella", "push", true, 120, 0, 1.1F, "El salto de la estrella, es un ejercicio pliométrico que exige potencia y coordinación para realizar adecuadamente.");
        exercisesHash.put("Saltoestrella", saltoEstrella);
        Exercise flexiones = new Exercise("Flexiones", "abdominales", false, 0, 15, 2.2F, "Las flexiones o fondos de brazos son un ejercicio muy habitual que se han utilizado desde siempre para entrenar y estar en forma.");
        exercisesHash.put("Flexiones", flexiones);
        Exercise plancha = new Exercise("Plancha", "plank", true, 80, 0, 1.2F, "La plancha abdominal es probablemente uno de los ejercicios más eficaces a la hora de fortalecer el core");
        exercisesHash.put("Plancha", plancha);
        Exercise abdominales = new Exercise("Abdominales", "abdominales", false, 0, 12, 2, "Túmbate boca arriba con las rodillas dobladas, si es posible sobre una colchoneta. Las rodillas deben doblarse en un ángulo que permita a los talones quedar lo más cerca posible de la parte anterior de los muslos.");
        exercisesHash.put("Abdominales", abdominales);
        Exercise mountainClimber = new Exercise("Mountain Climber", "air_squat", false, 0, 15, 1.9F, "Los mountain climbers son un ejercicio que combina la plancha isométrica clásica con la elevación de rodillas, trabajando así un montón de músculos al mismo tiempo y por lo tanto quemando bastantes más calorías que los simples crunches.");
        exercisesHash.put("Mountain", mountainClimber);
    }

}

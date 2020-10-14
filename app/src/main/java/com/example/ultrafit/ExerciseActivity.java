package com.example.ultrafit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Routine routine;
    int seconds;
    boolean running;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Intent intent = getIntent();
        routine = (Routine) intent.getSerializableExtra("routine");

        ((TextView)findViewById(R.id.exercise_title)).setText(routine.getExerciseLists().get(index).getName());
        boolean timer = routine.getExerciseLists().get(index).isHasLimitTime();
        int time = routine.getExerciseLists().get(index).getTime();
        int reps  = routine.getExerciseLists().get(index).getRepetitions();
        chooseTimerOrReps(timer, time, reps);
        index++;
        runTimer();

    }

    public void runTimer(){

        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running){
                    int minute = (seconds%3600)/60;
                    int sec = seconds%60;
                    String time = String.format("%02d : %02d", minute, sec);
                    ((TextView)findViewById(R.id.timer_text)).setText(time);
                    seconds--;
                    if(seconds == 0){
                        seguir();
                        seconds = 20;
                    }
                }
                if(running){
                    handler.postDelayed(this, 1000);
                }


            }
        });
    }

    public void chooseTimerOrReps(boolean timer, int seconds, int reps){
        if(timer){
            running = true;
            this.seconds = seconds;
            runTimer();
        }
        else{
            running = false;
            String repeticiones = String.format("x%d", reps);
            ((TextView)findViewById(R.id.timer_text)).setText(repeticiones);
        }
    }

    public void onSiguiente(View view){
        seguir();
    }

    public void seguir(){
        if(index < routine.getExerciseLists().size()){
            ((TextView)findViewById(R.id.exercise_title)).setText(routine.getExerciseLists().get(index).getName());
            boolean timer = routine.getExerciseLists().get(index).isHasLimitTime();
            int time = routine.getExerciseLists().get(index).getTime();
            int reps  = routine.getExerciseLists().get(index).getRepetitions();
            chooseTimerOrReps(timer, time, reps);
            index++;
        }

    }

    public void onSalir(View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}
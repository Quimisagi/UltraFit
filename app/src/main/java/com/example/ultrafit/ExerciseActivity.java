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
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Intent intent = getIntent();
        routine = (Routine) intent.getSerializableExtra("routine");

        ((TextView)findViewById(R.id.exercise_title)).setText(routine.getExerciseLists().get(index).getName());
        index++;
        seconds = 120;
        runTimer();

    }

    public void runTimer(){

        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minute = (seconds%3600)/60;
                int sec = seconds%60;
                String time = String.format("%d : %d", minute, sec);
                ((TextView)findViewById(R.id.timer_text)).setText(time);
                seconds--;
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onSiguiente(View view){
        ((TextView)findViewById(R.id.exercise_title)).setText(routine.getExerciseLists().get(index).getName());
        index++;
    }

    public void onSalir(View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}
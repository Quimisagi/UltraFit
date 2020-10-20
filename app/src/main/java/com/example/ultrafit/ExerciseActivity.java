package com.example.ultrafit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;
import java.lang.reflect.Field;

public class ExerciseActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    Routine routine;
    int seconds;
    boolean running;
    int index = 0;
    float caloriasTotales = 0;

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
        String videoName = routine.getExerciseLists().get(index).getVideoURL();
        chooseTimerOrReps(timer, time, reps);
        index++;
        runTimer();

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + getResId(videoName, R.raw.class);
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onSiguiente(View view){
        seguir();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void seguir(){
        if(index < routine.getExerciseLists().size()){
            ((TextView)findViewById(R.id.exercise_title)).setText(routine.getExerciseLists().get(index).getName());
            String videoName = routine.getExerciseLists().get(index).getVideoURL();
            VideoView videoView = findViewById(R.id.videoView);
            String videoPath = "android.resource://" + getPackageName() + "/" + getResId(videoName, R.raw.class);
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            boolean timer = routine.getExerciseLists().get(index).isHasLimitTime();
            int time = routine.getExerciseLists().get(index).getTime();
            int reps  = routine.getExerciseLists().get(index).getRepetitions();
            float cal = routine.getExerciseLists().get(index).getCalories();
            if(timer){
                caloriasTotales += cal * time;
            }
            else {
                caloriasTotales += cal * reps;
            }
            chooseTimerOrReps(timer, time, reps);
            index++;
        }
        else{
            openFinishedDialog();
            running = false;
            StaticsRegister.stopCountingTime(caloriasTotales);
        }
    }

    public void openFinishedDialog(){
        RoutineFinishedDialog dialog = new RoutineFinishedDialog();
        dialog.setCancelable(true);
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onSalir(View view) throws IOException {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        StaticsRegister.stopCountingTime(caloriasTotales);
        DataHandler.saveData(getApplicationContext(), RecordHandler.getInstance().getCalendarRecord(), "statics.txt");
        startActivity(intent);
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return ((Field) idField).getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
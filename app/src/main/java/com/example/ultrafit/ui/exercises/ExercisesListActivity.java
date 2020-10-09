package com.example.ultrafit.ui.exercises;

import android.content.Intent;
import android.os.Bundle;

import com.example.ultrafit.ObjectivesHandler;
import com.example.ultrafit.Routine;
import com.example.ultrafit.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ultrafit.R;

import java.util.ArrayList;
import java.util.List;

public class ExercisesListActivity extends AppCompatActivity {

    Routine routine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersies_list);
        Intent intent = getIntent();
        routine = (Routine) intent.getSerializableExtra("routine");
        getExercises();

    }

    public void getExercises(){
        for (int i = 0; i < routine.getExerciseLists().size(); i++){
            addExercise(routine.getExerciseLists().get(i).getName());
        }
    }

    public void addExercise(String exerciseName){

        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);

        TextView text = new TextView(this);
        text.setText(exerciseName);

        layout.addView(text);
    }

}
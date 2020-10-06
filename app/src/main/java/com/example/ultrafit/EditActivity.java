package com.example.ultrafit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        updateFields();
    }

    public void updateFields(){
        User tempUser = User.getInstance();
        ((EditText)findViewById(R.id.name)).setText(tempUser.getName());
        ((EditText)findViewById(R.id.age)).setText(tempUser.getAge());
        ((EditText)findViewById(R.id.stature)).setText(tempUser.getStature());
        ((EditText)findViewById(R.id.weight)).setText(tempUser.getWeight());
    }
}
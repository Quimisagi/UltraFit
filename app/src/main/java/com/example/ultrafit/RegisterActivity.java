package com.example.ultrafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if(User.getInstance().getName() != ""){
            updateFields(User.getInstance());
        }

    }

    public void onAccept(View view) throws IOException {
        EditText nameEdit = (EditText)findViewById(R.id.name);
        EditText ageEdit = (EditText)findViewById(R.id.age);
        EditText statureEdit = (EditText)findViewById(R.id.stature);
        EditText weightEdit = (EditText)findViewById(R.id.weight);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup_objective);

        String name = nameEdit.getText().toString();
        int age = Integer.parseInt(ageEdit.getText().toString());
        int stature = Integer.parseInt(statureEdit.getText().toString());
        int weight = Integer.parseInt(weightEdit.getText().toString());
        int buttonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(buttonID);
        int index = radioGroup.indexOfChild(radioButton);

        User tempUser = User.getInstance();
        tempUser.setName(name);
        tempUser.setAge(age);
        tempUser.setStature(stature);
        tempUser.setWeight(weight);
        tempUser.setObjective(index);

        DataHandler.saveData(getApplicationContext(), tempUser, "userData.txt");

        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void updateFields(User tempUser){
        ((EditText)findViewById(R.id.name)).setText(tempUser.getName());
        ((EditText)findViewById(R.id.age)).setText(String.valueOf(tempUser.getAge()));
        ((EditText)findViewById(R.id.stature)).setText(String.valueOf(tempUser.getStature()));
        ((EditText)findViewById(R.id.weight)).setText(String.valueOf(tempUser.getWeight()));

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup_objective);
        radioGroup.check(radioGroup.getChildAt(tempUser.getObjective()).getId());
    }
}
package com.example.ultrafit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.io.IOException;
import java.util.Hashtable;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        User tempUser = User.getInstance();
        Hashtable<String, DateRecord> calendarRecord = null;
        try {
            tempUser = (User)DataHandler.loadData(getApplicationContext(), "userData.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            calendarRecord = (Hashtable<String, DateRecord>) DataHandler.loadData(getApplicationContext(), "statics.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        checkSavedData(tempUser);
        if(calendarRecord != null){
            RecordHandler.getInstance().setCalendarRecord(calendarRecord);
        }
    }

    public void checkSavedData(User tempUser){

        if(tempUser.getName() != ""){
            toMainActivity();
            loadUserData(tempUser);
        }
    }

    public void loadUserData(User tempUser){
        User user = User.getInstance();
        user.setName(tempUser.getName());
        user.setAge(tempUser.getAge());
        user.setStature(tempUser.getStature());
        user.setWeight(tempUser.getWeight());
        user.setObjective(tempUser.getObjective());
    }

    public void toRegisterActivity(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void toMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
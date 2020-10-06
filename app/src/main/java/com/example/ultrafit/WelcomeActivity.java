package com.example.ultrafit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import java.io.IOException;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        User tempUser = User.getInstance();
        try {
            tempUser = (User)DataHandler.loadData(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        checkSavedData(tempUser);
    }

    public void checkSavedData(User tempUser){

        if(tempUser.getName() == ""){
            toRegisterActivity();
        }
        else{
            loadUserData(tempUser);
            toMainActivity();
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

    public Runnable redirectToActivityAfterDelay(Class<?> cls){
        final Intent intent = new Intent(this, cls);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                startActivity(intent);
            }
        };
        return r;
    }

    public void toRegisterActivity(){
        Handler h = new Handler();
        h.postDelayed(redirectToActivityAfterDelay(RegisterActivity.class), 2000);
    }

    public void toMainActivity(){
        Handler h = new Handler();
        h.postDelayed(redirectToActivityAfterDelay(MainActivity.class), 2000);
    }
}
package com.example.ultrafit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import java.io.IOException;

public class WelcomeActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        try {
            checkSavedData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkSavedData() throws IOException, ClassNotFoundException {
        User tempUser = (User)DataHandler.loadData(getApplicationContext());
        System.out.println(tempUser.getName());
        if(tempUser != null){
            toRegisterActivity();
        }
        else{
            toMainActivity();
        }
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
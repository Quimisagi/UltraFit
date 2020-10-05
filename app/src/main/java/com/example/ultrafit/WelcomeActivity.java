package com.example.ultrafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        toRegisterActivity();
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
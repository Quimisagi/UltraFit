package com.example.ultrafit;

import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import java.util.Calendar;

public class StaticsRegister {
    static StaticsRegister instance;
    static boolean running;
    static int seconds;
    static DateRecord todayRecord;

    private StaticsRegister(boolean running, int seconds) {
        this.running = running;
        this.seconds = seconds;
    }

    public static StaticsRegister getInstance(){
        if(instance == null){
            new StaticsRegister(false, 0);
        }
        return instance;
    }

    public static void startCountingTime(){
        checkCurrentDate();
        running = true;
        seconds = 0;
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running){
                    seconds++;
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    public static void checkCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        todayRecord = RecordHandler.getInstance().getRecordOfDate(year, month, day);
        if(todayRecord == null){
            RecordHandler.getInstance().registerNewRecord(year, month, day, seconds, 0);
            todayRecord = RecordHandler.getInstance().getRecordOfDate(year, month, day);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void stopCountingTime(float cal){
        running = false;
        int currentTime = todayRecord.getTime();
        float currentCal = todayRecord.getCalories();
        todayRecord.setTime(currentTime + seconds);
        todayRecord.setCalories(currentCal + cal);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        RecordHandler.getInstance().replaceRecord(year, month, day, todayRecord);
    }

    public static DateRecord getTodayRecord() {
        return todayRecord;
    }

    public static void setTodayRecord(DateRecord todayRecord) {
        StaticsRegister.todayRecord = todayRecord;
    }
}

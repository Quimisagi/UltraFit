package com.example.ultrafit;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Hashtable;

public class RecordHandler {

    static RecordHandler instance;

    Hashtable<String, DateRecord> calendarRecord;

    private RecordHandler(Hashtable<String, DateRecord> calendarRecord){
        this.calendarRecord = calendarRecord;
    }

    public static RecordHandler getInstance(){
        if(instance == null){
            instance = new RecordHandler(new Hashtable<String, DateRecord>());
        }
        return instance;
    }

    public Hashtable<String, DateRecord> getCalendarRecord() {
        return calendarRecord;
    }

    public void setCalendarRecord(Hashtable<String, DateRecord> calendarRecord) {
        this.calendarRecord = calendarRecord;
    }

    public void registerNewRecord(int year, int month, int day, int time, int calories){
        DateRecord newRecord = new DateRecord(time, calories);
        String yearS = Integer.toString(year);
        String monthS = Integer.toString(month);
        String dayS = Integer.toString(day);
        calendarRecord.put(yearS + monthS + dayS, newRecord);
    }

    public DateRecord getRecordOfDate(int year, int month, int day){
        String yearS = Integer.toString(year);
        String monthS = Integer.toString(month);
        String dayS = Integer.toString(day);
        return calendarRecord.get(yearS + monthS + dayS);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void replaceRecord(int year, int month, int day, DateRecord dateRecord){
        String yearS = Integer.toString(year);
        String monthS = Integer.toString(month);
        String dayS = Integer.toString(day);
        calendarRecord.replace(yearS + monthS + dayS, dateRecord);
    }

}

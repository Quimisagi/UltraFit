package com.example.ultrafit.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ultrafit.DateRecord;
import com.example.ultrafit.R;
import com.example.ultrafit.RecordHandler;

import java.util.Calendar;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    View view;
    CalendarView calendarView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);



        calendarView = (CalendarView) root.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                checkRecord(year, month, dayOfMonth);
            }
        });
        this.view = root;
        Calendar calendar = Calendar.getInstance();
        int yearT = calendar.get(Calendar.YEAR);
        int monthT = calendar.get(Calendar.MONTH);
        int dayT = calendar.get(Calendar.DAY_OF_MONTH);
        checkRecord(yearT, monthT, dayT);
        return root;
    }

    public void checkRecord(int year, int month, int day){
        DateRecord dateRecord = RecordHandler.getInstance().getRecordOfDate(year, month, day);
        if(dateRecord == null){
            view.findViewById(R.id.notFoundLayout).setVisibility(View.VISIBLE);
            view.findViewById(R.id.recordLayout).setVisibility(View.GONE);
        }
        else{
            view.findViewById(R.id.notFoundLayout).setVisibility(View.GONE);
            view.findViewById(R.id.recordLayout).setVisibility(View.VISIBLE);
            int seconds = dateRecord.getTime();
            int minute = (seconds%3600)/60;
            int sec = seconds%60;
            String time = String.format("%02d : %02d", minute, sec);
            ((TextView)view.findViewById(R.id.time)).setText(time);
            ((TextView)view.findViewById(R.id.calories)).setText(Float.toString(dateRecord.getCalories()));
        }

    }
}
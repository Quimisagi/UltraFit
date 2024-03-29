package com.example.ultrafit.ui.user;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ultrafit.EditActivity;
import com.example.ultrafit.R;
import com.example.ultrafit.RegisterActivity;
import com.example.ultrafit.Reminder;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class UserFragment extends Fragment implements View.OnClickListener {

    private NotificationsViewModel notificationsViewModel;
    Button editBtn;
    Switch switchN;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_users, container, false);

        editBtn = (Button)root.findViewById(R.id.edit_button);
        switchN =root.findViewById(R.id.notifications);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProfile();
            }
        });

        switchN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onNotifications();
            }
        });


        return root;
    }

    public void onProfile() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), RegisterActivity.class);
        getActivity().startActivity(intent);
    }

    public void onNotifications(){
        if(switchN.isChecked()){
            activeNotifications();
        }
        else{
            cancelNotifications();
        }

    }

    public void activeNotifications(){
        Intent intent = new Intent(getContext(), Reminder.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0,intent,0);
        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(ALARM_SERVICE);
        long triggerAfter = 50;
        long triggerEvery = 10;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,triggerAfter, triggerEvery,pendingIntent);
    }

    public void cancelNotifications(){
        Intent intent = new Intent(getContext(), Reminder.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0,intent,0);
        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onPrueba(){
        String id = "main_channel";
        CharSequence name = "Channel Name";
        String description = "Channel description";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        notificationChannel.setDescription(description);
        if(notificationChannel != null){
            notificationManager.createNotificationChannel((notificationChannel));
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getContext(), id).
                setSmallIcon(R.drawable.ic_notifications_black_24dp).
                setContentText("¿Ya entrenaste hoy?").
                setContentTitle("¡No olvides hacer ejercicios todos los días!");
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
        notificationManagerCompat.notify(1000, notificationBuilder.build());
    }

    @Override
    public void onClick(View v) {

    }
}
package com.example.ultrafit;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Reminder extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Recordatorio activado", Toast.LENGTH_SHORT);
        String id = "main_channel";
        CharSequence name = "Channel Name";
        String description = "Channel description";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        notificationChannel.setDescription(description);
        if(notificationChannel != null){
            notificationManager.createNotificationChannel((notificationChannel));
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, id).
                setSmallIcon(R.drawable.ic_notifications_black_24dp).
                setContentText("this is my notification").
                setContentTitle("my notificaton");
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1000, notificationBuilder.build());
        /*Intent intent1 = new Intent(context,MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).
                setSmallIcon(R.drawable.ic_notifications_black_24dp).
                setContentIntent(pendingIntent).
                setContentText("this is my notification").
                setContentTitle("my notificaton").
        setAutoCancel(true);
        notificationManager.notify(100,builder.build());*/

    }

}

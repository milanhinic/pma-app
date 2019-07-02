package com.example.pmaproject.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.pmaproject.MainActivity;
import com.example.pmaproject.R;

public class NotificationAlarmReceiver extends BroadcastReceiver {
    int mNotificationId = 001;

    public NotificationAlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Gets an instance of the NotificationManager service
        final NotificationManager mgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(context);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("PM APP")
                .setContentText("Novi popusti u vasoj omiljenoj radnji")
                .setAutoCancel(true); // clear notification after click

        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(context, mNotificationId, resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mNotificationId, mBuilder.build());
    }
}

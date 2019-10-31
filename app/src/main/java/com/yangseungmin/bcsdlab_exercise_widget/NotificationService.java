package com.yangseungmin.bcsdlab_exercise_widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.yangseungmin.bcsdlab_exercise_widget.MainActivity.CHANNEL_ID;

public class NotificationService extends Service {
    private static final int NOTIFICATION_ID = 1;
    private NotificationManagerCompat notificationManagerCompat;

    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("service", "onStartCommand");
        int max = intent.getExtras().getInt("max");
        int val = intent.getExtras().getInt("val");

        notificationManagerCompat = NotificationManagerCompat.from(this);
        createNotification(max, val);

        return super.onStartCommand(intent, flags, startId);
    }

    private void createNotification(int max, int val) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Random ")
                .setContentText("Here is a random number between 0 and " + max)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setProgress(max, val, false);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("service", "onDestroy");
        notificationManagerCompat.cancel(NOTIFICATION_ID);
    }
}

package mo.ed.course.two.amit.day.one.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import mo.ed.course.two.amit.day.one.R;
import mo.ed.course.two.amit.day.one.utils.Constants;
import mo.ed.course.two.amit.day.one.view.activities.NotificationsActivity;

public class MyForegroundService extends Service {
    private int NotificationRequestCode=1001;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String data= intent.getStringExtra(Constants.FOREGROUND_SERVICE_INTENT);

        createNotificationChannel();

        Intent notificationIntent= new Intent(MyForegroundService.this, NotificationsActivity.class);

        // pending Intent

        PendingIntent pendingIntent= PendingIntent.getActivity(this,NotificationRequestCode, notificationIntent, 0);

        Notification notification=new NotificationCompat.Builder(this, Constants.CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentIntent(pendingIntent)
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_notification)
                .build();

        startForeground(NotificationRequestCode, notification);
        Log.e("MyForegroundService","Started");
        return START_NOT_STICKY;
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel= new NotificationChannel(
                    Constants.CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyForegroundService","Destroyed|Stopped");
    }
}

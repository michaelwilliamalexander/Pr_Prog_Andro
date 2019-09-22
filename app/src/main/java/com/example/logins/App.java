package com.example.logins;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static  final String CHANNEL_1 = "WIFI ON";
    public static  final String CHANNEL_2 = "WIFI OFF";

    public void onCreate() {
        super.onCreate();
        createNotification();
    }

    private void createNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel on = new NotificationChannel(
                   CHANNEL_1,
                    "WIFI ON",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationChannel off = new NotificationChannel(
                    CHANNEL_2,
                    "WIFI OFF",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager =  getSystemService(NotificationManager.class);
            manager.createNotificationChannel(on);
            manager.createNotificationChannel(off);
        }
    }
}

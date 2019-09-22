package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import static com.example.logins.App.CHANNEL_1;
import static com.example.logins.App.CHANNEL_2;

public class HomeActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private TextView textView;
    private WifiManager wifiManager;
    private View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        String s = b.getString("Name");
        textView = findViewById(R.id.title);
        textView.setText(textView.getText()+"\n\n Welcome "+ s);

        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            if(wifiState==WifiManager.WIFI_STATE_ENABLED){
                Toast.makeText(getApplicationContext(),"WIFI ON",Toast.LENGTH_SHORT).show();
                wifiOn(v);
            }else if(wifiState==WifiManager.WIFI_STATE_DISABLED){
                Toast.makeText(getApplicationContext(),"WIFI OFF",Toast.LENGTH_SHORT).show();
                wifiOff(v);
            }
        }
    };

    protected void onStart(){
        super.onStart();
        registerReceiver(receiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));

    }

    protected  void onStop(){
        super.onStop();
        unregisterReceiver(receiver);
    }

    private  void wifiOn(View v ){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1)
                .setSmallIcon(R.drawable.ic_on)
                .setContentTitle("Congratulation")
                .setContentText("Yout WIFI already ON")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);
    }
    private void wifiOff(View v){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2)
                .setSmallIcon(R.drawable.ic_off)
                .setContentTitle("Congratulation")
                .setContentText("Yout WIFI already OFF")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);
    }


//    protected  void preparehome(){
//        this.getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new Home()).commit();
//    }
//    protected  void prepareabout(){
//        this.getSupportFragmentManager().beginTransaction().add(R.id.frameLayout1,new About()).commit();
//    }
//    protected void home() {
//        Button btn = (Button)findViewById(R.id.fraghome);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                preparehome();
//            }
//        });
//    }
////
//    protected void about(){
//        Button btn1 = (Button)findViewById(R.id.fragabout);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                prepareabout();
//            }
//        });
//    }
    }


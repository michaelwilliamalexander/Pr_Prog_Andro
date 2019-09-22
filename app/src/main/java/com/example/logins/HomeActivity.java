package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;

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
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    //boolean click = false;
    private TextView textView;
    private  boolean isReceiverRegister = false;
    private WifiManager wifiManager;
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
        textView.setText(textView.getText()+" \n"+ s);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            if(wifiState==WifiManager.WIFI_STATE_ENABLED){
                Toast.makeText(getApplicationContext(),"WIFI ON",Toast.LENGTH_SHORT).show();
                addNotification();
            }else if(wifiState==WifiManager.WIFI_STATE_DISABLED){
                Toast.makeText(getApplicationContext(),"WIFI OFF",Toast.LENGTH_SHORT).show();
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
    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Hello")
                .setContentText("Your WIFI is ON");
        Intent notificationIntent = new Intent(this,HomeActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());

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


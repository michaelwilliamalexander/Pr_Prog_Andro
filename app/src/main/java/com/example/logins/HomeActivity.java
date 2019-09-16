package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    //boolean click = false;
    private TextView textView;
    private  boolean isReceiverRegister = false;
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

    protected BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null){
                if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                   Toast.makeText(getApplicationContext(),"Wifi on",Toast.LENGTH_LONG).show();
                }
            }

        }
    };

    protected void onResume(){
        super.onResume();
        if(!isReceiverRegister){
            isReceiverRegister = true;
            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        }
    }

    protected  void onPause(){
        super.onPause();
        if(!isReceiverRegister){
            isReceiverRegister = false;
            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        }
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
//

    }


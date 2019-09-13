package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    //boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

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


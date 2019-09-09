package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        prepare();
        exit();
        about();
    }
    protected  void prepare(){
        this.getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new Fragment_Home()).commit();
    }
    protected void about() {
        Button btn = (Button)findViewById(R.id.Abbout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(HomeActivity.this, AboutActivity.class);
                finish();
                startActivity(about);

            }
        });
    }

    protected void exit(){
        Button btn1 = (Button)findViewById(R.id.exit);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    }


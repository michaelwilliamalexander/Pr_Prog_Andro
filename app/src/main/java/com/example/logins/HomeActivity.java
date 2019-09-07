package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        about();
        exit();
    }

    protected void exit(){
        btn = findViewById(R.id.exit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exit = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(exit);
            }
        });
    }

    protected void about(){
        btn.findViewById(R.id.about);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(HomeActivity.this,AboutActivity.class);
                finish();
                startActivity(about);
            }
        });
    }
}

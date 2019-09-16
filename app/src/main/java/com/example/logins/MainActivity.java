package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText email;
    private EditText pass;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignUp();
        login();
    }
    protected void SignUp(){
        signup = findViewById(R.id.join);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign = new Intent(MainActivity.this,SignUpActivity.class);
                finish();
                startActivity(sign);
            }
        });
    }
    protected void login() {
        email = findViewById(R.id.Email);
        pass = findViewById(R.id.Password);
        button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equalsIgnoreCase("michael.william@ti.ukdw.ac.id") && pass.getText().toString().equalsIgnoreCase("123")) {
                    Bundle b = new Bundle();
                    b.putString("Name", email.getText().toString());
                    Intent home = new Intent(MainActivity.this, HomeActivity.class);
                    home.putExtras(b);
                    finish();
                    startActivity(home);
                } else {
                    Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_LONG).show();
                }

            }

        });
    }


    }



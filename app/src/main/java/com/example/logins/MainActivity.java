package com.example.logins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private String x ;
    private String y;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Email = "EmailKey";
    public static final String Password = "PasswordKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignUp();
        login();
        if(!sharedpreferences.getAll().isEmpty()){
            Bundle b = new Bundle();
            email = findViewById(R.id.Email);
            b.putString("Name", sharedpreferences.getString(Email,email.getText().toString()));
            Intent home = new Intent(MainActivity.this, HomeActivity.class);
            home.putExtras(b);
            finish();
            startActivity(home);
        }
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
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equalsIgnoreCase("michael.william@ti.ukdw.ac.id") && pass.getText().toString().equalsIgnoreCase("123")) {
                    x = email.getText().toString();
                    y = pass.getText().toString();
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Email,x);
                    editor.putString(Password,y);
                    editor.commit();
                    Bundle b = new Bundle();
                    b.putString("Name", sharedpreferences.getString("Email",x));
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



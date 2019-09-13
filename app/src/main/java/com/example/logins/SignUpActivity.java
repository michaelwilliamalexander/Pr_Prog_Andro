package com.example.logins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private Button but;
    private EditText mail;
    private EditText passw;
    private EditText passconf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SignUp();
    }

    protected void SignUp(){
        mail = findViewById(R.id.Email_join);
        passw = findViewById(R.id.Pass_join);
        passconf = findViewById(R.id.Pass_comp);
        but = findViewById(R.id.signup);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mail.getText().toString().isEmpty() && passw.getText().toString().isEmpty() && passconf.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email dan Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                }else if(passw.getText().toString().equals(passconf.getText().toString())){
                    Intent baru = new Intent(SignUpActivity.this, HomeActivity.class);
                    finish();
                    startActivity(baru);
                }else{
                    Toast.makeText(getApplicationContext(),"Password dan Confirm Password tidak sama", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}

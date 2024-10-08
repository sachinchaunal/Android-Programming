package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    Button loginb;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        loginb=findViewById(R.id.login_btn);
        username = findViewById(R.id.username);
        password=findViewById(R.id.password);


        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = username.getText().toString();
                Toast.makeText(ThirdActivity.this, "Username is="+us, Toast.LENGTH_LONG).show();

                String ps=password.getText().toString();
                Toast.makeText(ThirdActivity.this,"Password is="+ps,Toast.LENGTH_LONG).show();

                if (us.equals("admin") && ps.equals("admin")){
                    Intent myintent=new Intent(ThirdActivity.this,FourthActivity.class);
                    startActivity(myintent);
                }
            }
        });

    }

    public void closePage(View v){
        finish();
    }

}
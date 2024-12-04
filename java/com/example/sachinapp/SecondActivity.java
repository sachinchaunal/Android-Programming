package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void closePage(View v){
        finish();
    }
    public void start(View view){
        Intent myIntent = new Intent(SecondActivity.this, MyService.class);
        startService(myIntent);
    }

    public void stop(View view){
        Intent myIntent = new Intent(SecondActivity.this, MyService.class);
        stopService(myIntent);
}

    public void thirdPage(View view){
        Intent mintent=new Intent(SecondActivity.this,ThirdActivity.class);
        startActivity(mintent);
    }

}
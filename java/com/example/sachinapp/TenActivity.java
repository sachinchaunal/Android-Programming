package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TenActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ten);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et = findViewById(R.id.editTextText);
    }

    public void callExplicit(View view) {
        //EXPLICIT INTENT
        Intent myIntent = new Intent(getApplicationContext(), TenActivity2.class);
        String str = et.getText().toString();
        myIntent.putExtra("myData", str);
        myIntent.putExtra("myData1", "DIWALI SWEETS");
        startActivity(myIntent);

    }

    public void closepage(View view)
    {
        finish();
    }
    public void nextpage(View view)
    {
        Intent myint=new Intent(TenActivity.this, ElevenActivity.class);
        startActivity(myint);
    }
}
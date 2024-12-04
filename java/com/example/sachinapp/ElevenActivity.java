package com.example.sachinapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ElevenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eleven);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void callimplicit(View view){
        Intent myintent=new Intent(Intent.ACTION_VIEW);
        myintent.setData(Uri.parse("https://sachinchaunal.vercel.app"));
        startActivity(myintent);
    }
    public void closepage(View view)
    {
        finish();
    }
    public void nextpage(View view)
    {
        Intent myi=new Intent(ElevenActivity.this, TwelveActivity.class);
        startActivity(myi);
    }
}
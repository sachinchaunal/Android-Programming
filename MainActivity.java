package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String GEHU="LifeC";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(GEHU,"On start has been called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(GEHU,"Resume kar deya hai");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(GEHU,"ROKING deya hai mana onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(GEHU,"ROK deya stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(GEHU,"Restart kar ra hu");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(GEHU,"Destroy khatam tata bye bye");
    }


//    linking XML with JAVA

    //    First method- Not to be used
    public void clickFunction(View view)
    {
        Toast.makeText(this,"Cick kar deya hai mana ",Toast.LENGTH_LONG).show();
    }

    //    Second Method
    Button btnJAVA;
    ImageView imgJAVA;


    public int[] imageResIds={
            R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };
    public int currentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(getApplicationContext(), "SachinChaunal", Toast.LENGTH_LONG).show();
        Log.d(GEHU,"On create has been called");

//        second method to link XML with JAVA
        btnJAVA=findViewById(R.id.btnXML);
        btnJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Second Method sa click keya",Toast.LENGTH_LONG).show();
            }
        });

//        Image View
        imgJAVA = findViewById(R.id.imgXML);
        imgJAVA.setImageResource(R.drawable.wgroup);

        // Set an OnClickListener for the ImageView
        imgJAVA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Image clicked!", Toast.LENGTH_SHORT).show();
                currentIndex=(currentIndex+1)%imageResIds.length;
                imgJAVA.setImageResource(imageResIds[currentIndex]);
            }
        });
    }

    public void nextPage(View vvs)
    {
        Intent myIntent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(myIntent);
    }

}
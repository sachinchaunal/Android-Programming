package com.example.sachinapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NineActivity extends AppCompatActivity {

    ToggleButton tgbtn;
    AutoCompleteTextView act;
    String myar[]={"India","Indonaisa","Iran","Irak"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tgbtn=findViewById(R.id.togglebtnxml);
        act=findViewById(R.id.actxml);
        tgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tgbtn.isChecked()){
                    Toast.makeText(NineActivity.this, "Button ON", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(NineActivity.this,"Button OFF",Toast.LENGTH_LONG).show();
                }
            }
        });
        ArrayAdapter myadapter2=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,myar);
        act.setThreshold(3);
        act.setAdapter(myadapter2);
    }

    public void closePage(View view){
        finish();
    }

}
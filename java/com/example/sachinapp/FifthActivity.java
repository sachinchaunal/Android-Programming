package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FifthActivity extends AppCompatActivity {

    Spinner myspinner;
    String []myarr={"hi","there","Spinner","List"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myspinner=findViewById(R.id.spinnerXML);
        ArrayAdapter myadapter=new ArrayAdapter(this,R.layout.template_arrayadapter,R.id.templatetext,myarr);
        myspinner.setAdapter(myadapter);
    }

    public void nextPage(View vs)
    {
        Intent myintent=new Intent(FifthActivity.this,SixthGridActivity.class);
        startActivity(myintent);
    }
    public void closePage(View view){
        finish();
    }
}
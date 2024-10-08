package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SixthGridActivity extends AppCompatActivity {
    GridView grdjava;
    String []arr={"hi","hello","3","4","6","7","8","9","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth_grid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        grdjava=findViewById(R.id.grdxml);
//        ArrayAdapter<String> myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(this, R.layout.template_arrayadapter, R.id.templatetext, arr);
        grdjava.setAdapter(myadapter);
    }
    public void closePage(View view){
        finish();
    }
    public void nextPage(View view){
        Intent myintent=new Intent(SixthGridActivity.this, SixthActivity.class);
        startActivity(myintent);
    }
}
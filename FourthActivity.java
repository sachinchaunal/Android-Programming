package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourthActivity extends AppCompatActivity {


    String []arr= {"Hello","hi","kasa ","Ho","Array","hai"};
    ListView mylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mylistView=findViewById(R.id.listviewxml);
        ArrayAdapter<String> myadapter=new ArrayAdapter<>(this,R.layout.template_arrayadapter,R.id.templatetext,arr);
        mylistView.setAdapter(myadapter);
    }
    public void nextPage(View view){
        Intent myintent=new Intent(FourthActivity.this, FifthActivity.class);
        startActivity(myintent);
    }
    public void closePage(View view){
        finish();
    }
}
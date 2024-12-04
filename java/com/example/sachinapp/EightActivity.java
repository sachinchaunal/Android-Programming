package com.example.sachinapp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EightActivity extends AppCompatActivity {

    EditText n1,n2;
    TextView ans;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eight);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        n1=findViewById(R.id.number1);
        n2=findViewById(R.id.number2);
        ans=findViewById(R.id.answer);
    }
    public void addNumber(View view){
        try {
            int a = Integer.parseInt(n1.getText().toString());
            int b = Integer.parseInt(n2.getText().toString());
            int c = a + b;
            ans.setText(String.valueOf(c));  // Convert int to string
        } catch (NumberFormatException e) {
            ans.setText("Invalid Input");  // Handle invalid input
        }
    }

    public void closePage(View view){
        finish();
    }
    public void nextPage(View view){
        Intent myint=new Intent(EightActivity.this,NineActivity.class);
        startActivity(myint);
    }
}
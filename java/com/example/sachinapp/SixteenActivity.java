package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SixteenActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;

    CheckBox ck1,ck2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixteen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rg=findViewById(R.id.rdgrpXML);

        ck1=findViewById(R.id.checkBox);
        ck2=findViewById(R.id.checkBox2);
    }

    public void rdSelect(View view){
        int radioId=rg.getCheckedRadioButtonId();
        rb=findViewById(radioId);

        if(radioId==-1)
        {
            Toast.makeText(this, "NO radio Selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "" + rb.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    public void chkBtn(View view)
    {
        if(ck1.isChecked())
        {
            Toast.makeText(this, "" + ck1.getText(), Toast.LENGTH_SHORT).show();
        }
        else if (ck2.isChecked()) {
            Toast.makeText(this, "" + ck2.getText(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Not checked", Toast.LENGTH_SHORT).show();
        }
    }


    public void closePage(View view){
        finish();
    }
    public void nextPage(View view)
    {
        Intent myintent=new Intent(SixteenActivity.this,SeventeenActivity.class);
        startActivity(myintent);
    }
}
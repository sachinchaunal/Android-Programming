package com.example.sachinapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TwentyActivity extends AppCompatActivity {

    EditText mobileno;
    ProgressBar pb;
    private boolean isVisible = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twenty);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mobileno=findViewById(R.id.editTextMobileNumber);
        pb=findViewById(R.id.progressBarTest);

    }
    public void pbShow(View view)
    {
        if(isVisible){
            pb.setVisibility(View.GONE);
            isVisible = false;
        }else{
            pb.setVisibility(View.VISIBLE);
            isVisible=true;}
    }

    public void sendSMS(View view)
    {
        if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
            sendMySMS();

        }
        else {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);

        }
    }

    public void sendMySMS()
    {

        String Number=mobileno.getText().toString();
        String SMS="Hello! This is the Test msg and is for only Applications Testing Purpose";

        try {
            SmsManager smsM=SmsManager.getDefault();
            smsM.sendTextMessage(Number,null,SMS,null,null);
            Toast.makeText(getApplicationContext(), "MESSAGE SENT", Toast.LENGTH_LONG).show();

        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "MESSAGE NOT SENT", Toast.LENGTH_LONG).show();
        }
    }


    public void callMe(View view)
    {
        if(checkSelfPermission(Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED)
        {
            callNumber();
        }
        else {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1);
        }
    }
    public void callNumber()
    {
        Intent callintent=new Intent(Intent.ACTION_DIAL);
        callintent.setData(Uri.parse("tel:9259326294"));
        startActivity(callintent);
    }




}
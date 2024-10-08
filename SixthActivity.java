package com.example.sachinapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SixthActivity extends AppCompatActivity {
    Intent myintent;
    boolean bound = false;
    BoundedService myBservice = new BoundedService() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public ServiceConnection sConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                BoundedService.LocalIBinder activityBinder = (BoundedService.LocalIBinder) iBinder;
                myBservice = activityBinder.getService();
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                bound = false;
            }
        };

    public void getNumber(View view) {
            if (bound) {
                int i = myBservice.getRandomNum();
                Toast.makeText(SixthActivity.this, "numbr" + i, Toast.LENGTH_SHORT).show();

            }
        }

    public void start(View view) {
        myintent = new Intent(this, BoundedService.class);
        bindService(myintent, sConnection, BIND_AUTO_CREATE);
    }

    public void stop(View vs) {
            unbindService(sConnection);
            bound = false;
        }

    public void closePage(View view){
        finish();
    }
    public void nextPage(View view){
            Intent myi =new Intent(SixthActivity.this, SeventhActivity.class);
            startActivity(myi);
    }
}
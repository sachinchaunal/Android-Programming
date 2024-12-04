package com.example.sachinapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Random;

public class BoundedService extends Service {

    private Random numberg=new Random();
    private IBinder mybinder=new LocalIBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }

    public class LocalIBinder extends Binder{
        BoundedService getService(){
            return BoundedService.this;
        }
    }
    public int getRandomNum(){
        return numberg.nextInt(100);
    }
}

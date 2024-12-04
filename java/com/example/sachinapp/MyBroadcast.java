package com.example.sachinapp;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)){
            int state=intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,BluetoothAdapter.ERROR);

            switch (state){
                case BluetoothAdapter.STATE_ON:
                    Toast.makeText(context, "Bluetooth ON", Toast.LENGTH_LONG).show();
                    break;
                case BluetoothAdapter.STATE_OFF:
                    Toast.makeText(context, "Bluetooth OFF", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}

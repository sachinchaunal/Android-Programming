package com.example.sachinapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SeventeenActivity extends AppCompatActivity {

    DatePicker dp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventeen);

        dp = findViewById(R.id.datepickerXML);

        // If using getMonth(), you need to get values dynamically, for example, using a button
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dp.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
                // Directly fetch selected values from the DatePicker
                int selectedMonth = dp.getMonth(); // Current month
                int selectedYear = dp.getYear();   // Current year
                Toast.makeText(SeventeenActivity.this, "Month=" + (selectedMonth + 1) + " Year=" + selectedYear, Toast.LENGTH_SHORT).show();
            });
        }
    }

    // Optional: Add a button to retrieve current values
    public void showCurrentDate(View view) {
        int month = dp.getMonth(); // 0-based index for the month
        int year = dp.getYear();
        int day = dp.getDayOfMonth();

        Toast.makeText(this, "Selected Date: " + day + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
    }

    public void closePage(View view) {
        finish();
    }

    public void nextPage(View view) {
        Intent myintent = new Intent(SeventeenActivity.this, EighteenActivity.class);
        startActivity(myintent);
    }
}

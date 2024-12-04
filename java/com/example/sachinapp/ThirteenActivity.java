package com.example.sachinapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirteenActivity extends AppCompatActivity {

    Button cnxtbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thirteen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cnxtbtn=findViewById(R.id.contextBtn);
        registerForContextMenu(cnxtbtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mymenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.m1)
        {
            Toast.makeText(this, "HOME SELECTED", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.m2)
        {
            Toast.makeText(this, "PRODUCT SELECTED", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.m3)
        {
            Toast.makeText(this, "SERVICE SELECTED", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }


    public void closePage(View view)
    {
        finish();
    }
    public void nextPage(View view)
    {
        Intent intent=new Intent(ThirteenActivity.this, FourteenActivity.class);
        startActivity(intent);
    }
}

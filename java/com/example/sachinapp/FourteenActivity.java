package com.example.sachinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourteenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourteen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openPopup(View view)
    {
        PopupMenu pp=new PopupMenu(FourteenActivity.this,view);
        pp.inflate(R.menu.mymenu);
        pp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id=menuItem.getItemId();
                if(id==R.id.m1)
                {
                    Toast.makeText(FourteenActivity.this,"Home",Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.m2)
                {
                    Toast.makeText(FourteenActivity.this, "PRODUCT SELECTED", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        pp.show();
    }


    public void closePage(View view){
        finish();
    }
    public void nextPage(View view)
    {
        Intent intent=new Intent(FourteenActivity.this, FifteenActivity.class);
        startActivity(intent);
    }
}
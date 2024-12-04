package com.example.sachinapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NineteenActivity extends AppCompatActivity {

    EditText stuId,stuName;
    Button buttonInsert,buttonShow,buttonUpdate,buttonDelete;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nineteen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        stuId=findViewById(R.id.editText_Id);
        stuName=findViewById(R.id.editText_Name);
        buttonInsert=findViewById(R.id.buttonInsert);
        buttonShow=findViewById(R.id.buttonShowData);
        buttonUpdate=findViewById(R.id.buttonUpdateData);
        buttonDelete=findViewById(R.id.buttonDeleteData);

        DbHandler myhandler=new DbHandler(this);


        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int StudentID=Integer.parseInt(stuId.getText().toString());
                String StudentName=stuName.getText().toString();

                boolean insertData=myhandler.insertStuDetails(StudentID,StudentName);
                if(insertData==true)
                {
                    Toast.makeText(NineteenActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(NineteenActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });


        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=myhandler.retreveStuDetails();
                if(cursor.getCount()==0)
                {
                    Toast.makeText(NineteenActivity.this,"Data Not Found",Toast.LENGTH_SHORT).show();
                }
                else {
                    StringBuffer buffer=new StringBuffer();
                    while (cursor.moveToNext())
                    {
                        buffer.append("Student ID : " + cursor.getString(0) +"\n");
                        buffer.append("Student Name : " + cursor.getString(1) +"\n\n");
                    }

                    AlertDialog.Builder dbox=new AlertDialog.Builder(NineteenActivity.this);
//                    dbox.setCancelable(false);
                    dbox.setTitle("Student Record Database");
                    dbox.setMessage(buffer.toString());
                    dbox.show();
                }
            }
        });


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(stuId.getText().toString());
                String name=stuName.getText().toString();

                boolean updatedata=myhandler.updateStuDetails(id,name);

                if (updatedata==true){
                    Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Data Not Updated", Toast.LENGTH_LONG).show();
                }

            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(stuId.getText().toString());

                boolean deletedata=myhandler.deleteStuDetails(id);

                if (deletedata==true){
                    Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Data Not Deleted", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    public void closePage(View view)
    {
        finish();
    }

    public void nextPage(View view)
    {
        Intent myintent=new Intent(NineteenActivity.this, TwentyActivity.class);
        startActivity(myintent);
    }

}
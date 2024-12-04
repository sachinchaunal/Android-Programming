package com.example.sachinapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    private static final String DB_Name="studentDB.db";
    private static final int DB_VERSION = 1;


    public DbHandler(Context context) {
        super(context, DB_Name, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table studentDetails(student_id INTEGER primary key,student_name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS studentDetails");
    }



    public boolean insertStuDetails(int stuId,String stuName)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("student_id",stuId);
        cv.put("student_name",stuName);

        long result=db.insert("studentDetails",null,cv);
        if (result==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }


    public Cursor retreveStuDetails()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from studentDetails",null);
        return cursor;
    }



    public boolean updateStuDetails(int StuId ,String StuName)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("student_name",StuName);

        Cursor cursor=db.rawQuery("select * from studentDetails where student_id='"+StuId+"'",null);
        if(cursor.getCount()>0)
        {
            long result=db.update("studentDetails",cv,"student_id='"+StuId+"'",null);
            if (result==-1)
            {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }



    public Boolean deleteStuDetails(int stuID){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from studentDetails where student_ID ='" + stuID +"'", null);

        if(cursor.getCount()>0){
            long result = DB.delete("studentDetails", "student_ID ='" + stuID +"'", null);
            if(result ==-1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }



}

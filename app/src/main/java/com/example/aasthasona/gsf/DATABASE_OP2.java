package com.example.aasthasona.gsf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by aasthasona on 27-04-2015.
 */
public class DATABASE_OP2 extends SQLiteOpenHelper{
    public static final String WORDS = "words";
    public static final String CON = "Contractions";
    public static final String name = "Slangs";
    public static final String TABLE_NAME = "retname";
    public static final int database_version = 1;
    public SLGVARIABLES info;

    public DATABASE_OP2(Context context){
        super (context,name,null,database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" + WORDS + " TEXT, " + CON  + " TEXT" + ")";

        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created") ;

    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void putinfo(SLGVARIABLES varible){
        SQLiteDatabase sdb = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(WORDS,varible.getwords());
        cv.put(CON,varible.getContraction());

        sdb.insert(TABLE_NAME,null,cv);
        sdb.close();

        Log.d("rajat","One row inserted");

    }

    public SLGVARIABLES read(String w){
        SQLiteDatabase sdb = this.getReadableDatabase();

        Cursor c = sdb.query(TABLE_NAME, new String[]{WORDS,CON}, WORDS + "=?" ,new String[]{w},null,null,null,null);

        if (c != null) {
            c.moveToFirst();
            info = new SLGVARIABLES(c.getString(0), c.getString(1));
            return info;
        }
        else {
            return null;
        }

    }

    public int count(){
        String cquery = "SELECT * FROM" + TABLE_NAME;
        SQLiteDatabase sdb = this.getReadableDatabase();
        Cursor c = sdb.rawQuery(cquery,null);
        c.close();

        return c.getCount();
    }

}

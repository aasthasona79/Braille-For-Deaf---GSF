package com.example.aasthasona.gsf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by aasthasona on 25-03-2015.
 */
public class DATABASE_OPERATIONS extends SQLiteOpenHelper {

        public static final String WORDS = "words";
        public static final String cell1 = "motornum1";
        public static final String cell2 = "motornum2";
        public static final String cell3 = "motornum3";
        public static final String cell4 = "motornum4";
        public static final String name = "Contractions info";
        public static final String TABLE_NAME = "contractions";
        public static final int database_version = 1;
        public VARIABLES info;


    public  DATABASE_OPERATIONS(Context context){
        super (context, name, null, database_version);

    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" + WORDS + " TEXT, " + cell1 + " TEXT, " +cell2 + " TEXT, " +cell3 + " TEXT, " +cell4 + " TEXT" + ")";

        db.execSQL(CREATE_QUERY);
        Log.d("Database operations","Table created") ;



    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void putinformation(VARIABLES entries){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv= new ContentValues();
        cv.put(WORDS,entries.getwords());
        cv.put(cell1,entries.getcell1());
        cv.put(cell2,entries.getCell2());
        cv.put(cell3,entries.getCell3());
        cv.put(cell4,entries.getCell4());

        db.insert(TABLE_NAME, null,cv);
        db.close();
        Log.d("Database operations","Database one row inserted") ;

    }
    public  VARIABLES readinfo(String WORDSID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("rajat","check started");

        Cursor c = db.query(TABLE_NAME, new String[]{WORDS,cell1,cell2,cell3,cell4}, WORDS + "=?",new String[]{WORDSID},null,null,null,null);


        if (c != null) {
           c.moveToFirst();
               info = new VARIABLES(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            /*c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4)*/
               Log.d("rajat","hdahd");
            return info;

        }
        else {
            return null;
        }
    }
}

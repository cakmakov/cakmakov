package com.example.sweproject3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "veritabani";
    private static final int DATABASE_VERSION = 1;
    private static final String GOREVLER_TABLE = "gorevler";

    private static final String ROW_ID = "id";
    private static final String ROW_GOREV = "gorev";

    public Veritabani (Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + GOREVLER_TABLE + " (" + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ROW_GOREV + " TEXT NOT NULL);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS" + GOREVLER_TABLE);
        onCreate(db);

    }

    public void VeriEkle(String gorev){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_GOREV, gorev.trim());
        db.insert(GOREVLER_TABLE, null, cv);
        db.close();

    }

    public List<String> VeriListele(){

        List<String> veriler = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] satirlar = {ROW_ID,ROW_GOREV};
        Cursor cursor = db.query(GOREVLER_TABLE,satirlar,null,null,null,null,null);
        while (cursor.moveToNext()){

            veriler.add(cursor.getInt(0) + " - " + cursor.getString(1));


        }
        return veriler;
    }

    public void VeriSil(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(GOREVLER_TABLE, ROW_ID + "=" + id, null);
        db.close();
    }
}
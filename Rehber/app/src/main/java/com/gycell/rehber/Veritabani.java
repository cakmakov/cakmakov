package com.gycell.rehber;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Güler on 17.5.2017.
 */

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "veritabani";
    private static final int DATABASE_VERSION = 1;
    private static final String KISILER_TABLE = "kisiler";

    private static final String ROW_ID = "id";
    private static final String ROW_NAME = "ad";
    private static final String ROW_SURNAME = "soyad";
    private static final String ROW_PHONE = "telefon";
    private static final String ROW_MAIL = "email";

    public Veritabani (Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + KISILER_TABLE + " (" + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ROW_NAME + " TEXT NOT NULL, " + ROW_SURNAME + " TEXT NOT NULL, " + ROW_PHONE + " TEXT NOT NULL, " + ROW_MAIL + " TEXT NOT NULL);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS" + KISILER_TABLE);
        onCreate(db);

    }

    public void VeriEkle(String ad,String soyad,String telefon,String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_NAME, ad.trim());
        cv.put(ROW_SURNAME, soyad.trim());
        cv.put(ROW_PHONE, telefon.trim());
        cv.put(ROW_MAIL, email.trim());
        db.insert(KISILER_TABLE, null, cv);
        db.close();

    }

    public List<String> VeriListele(){

        List<String> veriler = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] satirlar = {ROW_ID,ROW_NAME,ROW_SURNAME,ROW_PHONE,ROW_MAIL};
        Cursor cursor = db.query(KISILER_TABLE,satirlar,null,null,null,null,null);
        while (cursor.moveToNext()){

            veriler.add(cursor.getInt(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2) + " - " + cursor.getString(3) + " - " + cursor.getString(4));


        }
        return veriler;
    }

    public void VeriSil(long id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(KISILER_TABLE, ROW_ID + "=" + id, null);
        db.close();
    }
}

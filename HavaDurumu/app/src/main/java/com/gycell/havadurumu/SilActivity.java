package com.gycell.havadurumu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SilActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private String myPreferences;
    private String dosyaAdi = "deneme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        preferences = getSharedPreferences(dosyaAdi,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("key");
        editor.commit();


    }
}

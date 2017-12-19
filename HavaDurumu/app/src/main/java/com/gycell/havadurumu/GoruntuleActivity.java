package com.gycell.havadurumu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GoruntuleActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private String myPreferences;
    private String dosyaAdi = "deneme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goruntule);


        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.goruntulemeEkrani);

        preferences = getSharedPreferences(dosyaAdi, 0);
        String geridonenveri = preferences.getString("key", "Şehir yoktur.");
        textView.setText(geridonenveri);


    }
}

package com.gycell.hesapmakinesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SonucGoster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonuc_goster);


        Intent intent = getIntent();
        String value = intent.getStringExtra(MainActivity.EXTRA_VALUE);

        TextView sonucMetni = (TextView) findViewById(R.id.sonucEkrani);
        sonucMetni.setText(value);

    }
}

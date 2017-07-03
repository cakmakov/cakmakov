package com.gycell.havadurumu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KaydetActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private String myPreferences;
    private String dosyaAdi = "deneme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydet);

        Intent intent = getIntent();

        preferences = getSharedPreferences(dosyaAdi, 0);

        TextView textView = (TextView)findViewById(R.id.metin1);
        final EditText editText = (EditText)findViewById(R.id.sehirEkrani);
        Button buton1 = (Button)findViewById(R.id.button);
        Button buton2 = (Button)findViewById(R.id.button2);


        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alinanVeri = editText.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("key",alinanVeri);
                editor.commit();

            }
        });

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText("");

            }
        });




    }
}

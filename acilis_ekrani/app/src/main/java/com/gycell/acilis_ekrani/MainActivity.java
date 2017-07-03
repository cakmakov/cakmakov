package com.gycell.acilis_ekrani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_INFO = "com.gycell.acilis_ekrani.INFO";

    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            }

            public void bilgiGoster(View view){

                Intent intent = new Intent(this,bilgiGosterActivity.class);
                editText1 = (EditText)findViewById(R.id.kullaniciGiris);
                editText2 = (EditText)findViewById(R.id.sifreGiris);
                String kullaniciAdi = editText1.getText().toString();
                String sifre = editText2.getText().toString();
                String tcNo = "12345678901";
                intent.putExtra(EXTRA_INFO,kullaniciAdi);
                intent.putExtra(EXTRA_INFO,sifre);
                intent.putExtra(EXTRA_INFO,tcNo);
                startActivity(intent);

            }

        }




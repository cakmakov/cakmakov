package com.gycell.rehber;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String ad;
    String soyad;
    String telefon;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editText1 = (EditText) findViewById(R.id.adEkrani);
        final EditText editText2 = (EditText) findViewById(R.id.soyadEkrani);
        final EditText editText3 = (EditText) findViewById(R.id.telefonEkrani);
        final EditText editText4 = (EditText) findViewById(R.id.mailEkrani);
        Button button1 = (Button) findViewById(R.id.ekleButon);
        Button button2 = (Button) findViewById(R.id.silButon);
        Button button3 = (Button) findViewById(R.id.guncelleButon);
        Button button4 = (Button) findViewById(R.id.listeleButon);
        Button button5 = (Button) findViewById(R.id.araButon);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Veritabani veritabani = new Veritabani(MainActivity.this);
                veritabani.VeriEkle(editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString());

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, ListeActivity.class);
                startActivity(intent1);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Veritabani veritabani = new Veritabani(MainActivity.this);
                veritabani.VeriSil(1);
                veritabani.VeriSil(2);
                veritabani.VeriSil(3);
                veritabani.VeriSil(4);
                veritabani.VeriSil(5);
                veritabani.VeriSil(6);
                veritabani.VeriSil(7);
                veritabani.VeriSil(8);
                veritabani.VeriSil(9);
                veritabani.VeriSil(10);


            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent2 = new Intent(Intent.ACTION_CALL);
                intent2.setData(Uri.parse("tel: " + editText3.getText().toString().trim()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent2);

            }
        });

    }
}

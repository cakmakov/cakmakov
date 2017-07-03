package com.gycell.havadurumu;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] sehirler = {"istanbul","ankara","izmir","bursa","adana","sakarya","eskişehir","antalya"};
    public final static String EXTRA_INFO = "com.gycell.havadurumu.BILGI";
    private String myPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView1 = (TextView)findViewById(R.id.yazi1);
        TextView textView2 = (TextView)findViewById(R.id.yazi2);
        final EditText editText = (EditText)findViewById(R.id.sehirGirisEkrani);
        Button button1 = (Button)findViewById(R.id.tamamButonu);
        Button button2 = (Button)findViewById(R.id.ekleButonu);
        Button button3 = (Button)findViewById(R.id.goruntuleButonu);
        Button button4 = (Button)findViewById(R.id.silButonu);



        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

               String sehir = editText.getText().toString();

                if (Objects.equals(sehir, "istanbul")){

                    Uri webpage1 = Uri.parse("https://www.mgm.gov.tr/?il=Istanbul");
                    Intent intent1 = new Intent(Intent.ACTION_VIEW,webpage1);
                    startActivity(intent1);


                }else if (Objects.equals(sehir, "ankara")){

                    Uri webpage2 = Uri.parse("https://www.mgm.gov.tr/?il=Ankara");
                    Intent intent2 = new Intent(Intent.ACTION_VIEW,webpage2);
                    startActivity(intent2);

                }else if (Objects.equals(sehir, "izmir")){

                    Uri webpage3 = Uri.parse("https://www.mgm.gov.tr/?il=Izmir");
                    Intent intent3 = new Intent(Intent.ACTION_VIEW,webpage3);
                    startActivity(intent3);

                }else if (Objects.equals(sehir, "bursa")){

                    Uri webpage4 = Uri.parse("https://www.mgm.gov.tr/?il=Bursa");
                    Intent intent4 = new Intent(Intent.ACTION_VIEW,webpage4);
                    startActivity(intent4);

                }else if (Objects.equals(sehir, "adana")){

                    Uri webpage5 = Uri.parse("https://www.mgm.gov.tr/?il=Adana");
                    Intent intent5 = new Intent(Intent.ACTION_VIEW,webpage5);
                    startActivity(intent5);

                }else if (Objects.equals(sehir, "sakarya")){

                    Uri webpage6 = Uri.parse("https://www.mgm.gov.tr/?il=Sakarya");
                    Intent intent6 = new Intent(Intent.ACTION_VIEW,webpage6);
                    startActivity(intent6);

                }else if (Objects.equals(sehir, "eskişehir")){

                    Uri webpage7 = Uri.parse("https://www.mgm.gov.tr/?il=Eskisehir");
                    Intent intent7 = new Intent(Intent.ACTION_VIEW,webpage7);
                    startActivity(intent7);

                }else if (Objects.equals(sehir, "antalya")){

                    Uri webpage8 = Uri.parse("https://www.mgm.gov.tr/?il=Antalya");
                    Intent intent8 = new Intent(Intent.ACTION_VIEW,webpage8);
                    startActivity(intent8);

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent9 = new Intent(MainActivity.this,KaydetActivity.class);
                startActivity(intent9);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent10 = new Intent(MainActivity.this,GoruntuleActivity.class);
                startActivity(intent10);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent11 = new Intent(MainActivity.this,SilActivity.class);
                startActivity(intent11);

            }
        });

    }
}

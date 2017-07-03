package com.gycell.hesapmakinesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_VALUE = "com.gycell.hesapmakinesi.DEGER";
    Button sayi_0,sayi_1,sayi_2,sayi_3,sayi_4,sayi_5,sayi_6,sayi_7,sayi_8,sayi_9,sayi_topla,sayi_cikar,sayi_carp,sayi_bol,sayi_sil,hesapla;
    TextView girisEkrani;
    private float ilkdeger=0;
    private double sonuc=0;
    private String islem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hesapla=(Button)findViewById(R.id.hesapla);
        sayi_0=(Button)findViewById(R.id.sayi_0);
        sayi_1=(Button)findViewById(R.id.sayi_1);
        sayi_2=(Button)findViewById(R.id.sayi_2);
        sayi_3=(Button)findViewById(R.id.sayi_3);
        sayi_4=(Button)findViewById(R.id.sayi_4);
        sayi_5=(Button)findViewById(R.id.sayi_5);
        sayi_6=(Button)findViewById(R.id.sayi_6);
        sayi_7=(Button)findViewById(R.id.sayi_7);
        sayi_8=(Button)findViewById(R.id.sayi_8);
        sayi_9=(Button)findViewById(R.id.sayi_9);
        sayi_topla=(Button)findViewById(R.id.sayi_topla);
        sayi_cikar=(Button)findViewById(R.id.sayi_cikar);
        sayi_carp=(Button)findViewById(R.id.sayi_carp);
        sayi_bol=(Button)findViewById(R.id.sayi_bol);
        sayi_sil=(Button)findViewById(R.id.sayi_sil);
        girisEkrani =(TextView)findViewById(R.id.girisEkrani);



        sayi_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"0");
            }
        });

        sayi_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"1");

            }
        });
        sayi_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"2");

            }
        });
        sayi_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"3");

            }
        });
        sayi_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"4");

            }
        });
        sayi_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"5");

            }
        });
        sayi_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"6");

            }
        });
        sayi_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"7");

            }
        });
        sayi_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"8");

            }
        });
        sayi_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girisEkrani.setText(girisEkrani.getText()+"9");

            }
        });
        try{

            sayi_sil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ilkdeger=0;
                    sonuc=0;
                    girisEkrani.setText("");
                }
            });
        }
        catch (Exception c){}

        try{

            sayi_topla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ilkdeger=0;
                    sonuc=0;
                    if(!girisEkrani.getText().toString().equals("")){
                        ilkdeger=Float.parseFloat(girisEkrani.getText().toString());
                        girisEkrani.setText("");
                        islem="Toplama";

                    }

                }
            });
        }
        catch (Exception c){}

        try{

            sayi_cikar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ilkdeger=0;
                    sonuc=0;
                    if(!girisEkrani.getText().toString().equals("")){
                        ilkdeger=Float.parseFloat(girisEkrani.getText().toString());
                        girisEkrani.setText("");
                        islem="Çıkarma";

                    }

                }
            });
        }
        catch (Exception c){}

        try{

            sayi_carp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ilkdeger=0;
                    sonuc=0;
                    if(!girisEkrani.getText().toString().equals("")){
                        ilkdeger=Float.parseFloat(girisEkrani.getText().toString());
                        girisEkrani.setText("");
                        islem="Çarpma";

                    }

                }
            });
        }
        catch (Exception c){}

        try{

            sayi_bol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ilkdeger=0;
                    sonuc=0;
                    if(!girisEkrani.getText().toString().equals("")){
                        ilkdeger=Float.parseFloat(girisEkrani.getText().toString());
                        girisEkrani.setText("");
                        islem="Bölme";

                    }

                }
            });
        }
        catch (Exception c){}
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!girisEkrani.getText().toString().equals("") && !String.valueOf(ilkdeger).equals("0")){
                    if(islem.equals("Toplama")){
                        sonuc=ilkdeger + Float.parseFloat(girisEkrani.getText().toString());
                    }
                    else if(islem.equals("Çıkarma")){
                        sonuc=ilkdeger - Float.parseFloat(girisEkrani.getText().toString());

                    }
                    else if(islem.equals("Çarpma")){
                        sonuc=ilkdeger * Float.parseFloat(girisEkrani.getText().toString());

                    }

                    else if(islem.equals("Bölme")){
                        sonuc=ilkdeger / Float.parseFloat(girisEkrani.getText().toString());

                    }
                    girisEkrani.setText(String.valueOf(sonuc));
                    ilkdeger=0;
                    sonuc=0;

                }
                else{
                    girisEkrani.setText("Değer girmediniz.");

                }
                if (R.id.sayi_sil == view.getId()) {
                    ilkdeger=0;
                    sonuc=0;
                    girisEkrani.setText("");
                }

                Intent intent = new Intent(MainActivity.this,SonucGoster.class);
                TextView sonuc = (TextView)findViewById(R.id.girisEkrani);
                String info = sonuc.getText().toString();
                intent.putExtra(EXTRA_VALUE,info);
                startActivity(intent);

            }
        });






    }
}

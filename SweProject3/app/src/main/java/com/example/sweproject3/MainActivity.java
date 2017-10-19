package com.example.sweproject3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView)findViewById(R.id.gorevListesi);
        final Veritabani veritabani = new Veritabani(MainActivity.this);
        final List<String> veriler = veritabani.VeriListele();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,veriler);
        listView.setAdapter(arrayAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.gorevEklemeButonu:

                final EditText gorevGirisi = new EditText(this);
                AlertDialog.Builder gorevPenceresi = new AlertDialog.Builder(this);
                gorevPenceresi.setTitle("Görev Penceresi");
                gorevPenceresi.setMessage("Lütfen Görev Tanımlayınız.");
                gorevPenceresi.setView(gorevGirisi);
                gorevPenceresi.setPositiveButton("EKLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String gorev = gorevGirisi.getText().toString();
                        Veritabani veritabani = new Veritabani(MainActivity.this);
                        veritabani.VeriEkle(gorevGirisi.getText().toString());

                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);


                    }
                });

                gorevPenceresi.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                gorevPenceresi.show();

                return true;

            case R.id.gorevSilmeButonu:

                final EditText gorevSil = new EditText(MainActivity.this);
                AlertDialog.Builder gorevSilmePenceresi = new AlertDialog.Builder(MainActivity.this);
                gorevSilmePenceresi.setTitle("Görev Silme Penceresi");
                gorevSilmePenceresi.setMessage("Silmek İstediğiniz Görevin ID sini giriniz.");
                gorevSilmePenceresi.setView(gorevSil);
                gorevSilmePenceresi.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String gorev2 = gorevSil.getText().toString();
                        Veritabani veritabani = new Veritabani(MainActivity.this);
                        veritabani.VeriSil(gorev2);

                        Intent intent2 = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent2);

                    }
                });

                gorevSilmePenceresi.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
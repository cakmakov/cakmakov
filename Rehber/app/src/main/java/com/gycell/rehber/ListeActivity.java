package com.gycell.rehber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        final ListView listView = (ListView)findViewById(R.id.liste);

        Veritabani veritabani = new Veritabani(this);
        List<String> vVeriler = veritabani.VeriListele();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,vVeriler);
        listView.setAdapter(adapter);


    }
}

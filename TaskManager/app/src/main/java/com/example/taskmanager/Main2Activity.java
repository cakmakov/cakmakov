package com.example.taskmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    public final static String EXTRA_INFO = "com.example.taskmanager.INFO";
    List<String> veriler;
    List<String> keys;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        keys = new ArrayList();
        ListView listView = (ListView)findViewById(R.id.gorevListesi);
        veriler = new ArrayList<>();
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Tasks");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               for (DataSnapshot gelenler: dataSnapshot.getChildren()){

                   veriler.add(gelenler.getValue(Ekle.class).getEkleCalisan()+"-"+gelenler.getValue(Ekle.class).getEkleGorev());
                   keys.add(gelenler.getValue(Ekle.class).getEkleId());

               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ArrayAdapter adapter = new ArrayAdapter(Main2Activity.this,android.R.layout.simple_list_item_1,android.R.id.text1,veriler);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {


                AlertDialog.Builder silBuilder = new AlertDialog.Builder(Main2Activity.this);
                silBuilder.setTitle("Bildirim");
                silBuilder.setMessage("Hangi İşlemi Yapmak İstiyorsunuz?");
                silBuilder.setPositiveButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Tasks");
                        dbRef.getRef().child(keys.get(position)).setValue(null);

                        Intent intent = new Intent(Main2Activity.this,Main2Activity.class);
                        startActivity(intent);

                    }
                });
                silBuilder.setNegativeButton("GÜNCELLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String s = keys.get(position);
                        Intent intent = new Intent(Main2Activity.this,GorevGuncelleme.class);
                        intent.putExtra(EXTRA_INFO,s);
                        startActivity(intent);

                    }
                });

                silBuilder.show();

                return false;
            }
        });

    }


    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.anaSayfaButonu:


                Intent intent3 = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent3);


                return true;



            case R.id.gorevEklemeButonu:


                Intent intent4 = new Intent(Main2Activity.this,GorevTanimlama.class);
                startActivity(intent4);


                return true;



            case R.id.yenile:

                Intent intent5 = new Intent(Main2Activity.this,Main2Activity.class);
                startActivity(intent5);



                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    FirebaseAuth auth;
    List<String> anahtar;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i = getIntent();

        message = i.getStringExtra(CalisanGiris.EXTRA_INFO);

        auth = FirebaseAuth.getInstance();

        anahtar = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.list);
        final ArrayList datas = new ArrayList();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Tasks");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot gelenler : dataSnapshot.getChildren()) {

                    datas.add(gelenler.getValue(Ekle.class).getEkleCalisan() + "-" + gelenler.getValue(Ekle.class).getEkleGorev());
                    anahtar.add(gelenler.getValue(Ekle.class).getEkleId());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ArrayAdapter adapter = new ArrayAdapter(Main3Activity.this, android.R.layout.simple_list_item_1, android.R.id.text1, datas);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                builder.setTitle("Bildirim");
                builder.setMessage("Görev Tamamlandı Mı?");
                builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String person = datas.get(position).toString();
                        String[] personArray = person.split("-");


                        if (personArray[0].equals(message)){

                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Tasks");
                            dbRef.getRef().child(anahtar.get(position)).setValue(null);

                        Intent intent = new Intent(Main3Activity.this, Main3Activity.class);
                        startActivity(intent);


                            } else {

                                Toast.makeText(getApplicationContext(), "Sadece Kendinize Ait Görevleri Silebilirsiniz.", Toast.LENGTH_LONG).show();


                            }


                    }
                });

                builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });

                builder.show();

                return false;
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.yenile:


                Intent intent = new Intent(Main3Activity.this, Main3Activity.class);
                startActivity(intent);


                return true;

            case R.id.anaSayfayaDon:


                Intent intent2 = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(intent2);


                return true;

            case R.id.cikis:


                auth.signOut();
                Intent intent3 = new Intent(Main3Activity.this,CalisanGiris.class);
                startActivity(intent3);


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

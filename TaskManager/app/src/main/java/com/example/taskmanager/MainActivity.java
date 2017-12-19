package com.example.taskmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> gelenList;
    String sifre = "rasyona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        gelenList = new ArrayList();



        Button btn1= (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatabaseReference dbRef2 = db.getReference("Verification");
                String key2 = dbRef2.push().getKey();
                DatabaseReference dbRefKeyli2 = db.getReference("Verification/"+key2);

                dbRefKeyli2.setValue(new Dogrulama(sifre));

                EditText dogrulama = new EditText(MainActivity.this);
                final String bilgi = dogrulama.getText().toString().trim();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Doğrulama");
                builder.setMessage("Şifrenizi Giriniz.");
                builder.setView(dogrulama);
                builder.setPositiveButton("GİRİŞ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseReference dR = db.getReference("Verification");
                        dR.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                for (DataSnapshot gelen: dataSnapshot.getChildren()){

                                    gelenList.add(gelen.getValue(Dogrulama.class).getDogrulamaSifre());
                                    if(gelenList.contains("rasyona")){

                                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                                        startActivity(intent);

                                    }else {

                                        Toast.makeText(getApplicationContext(),"Hatalı Şifre",Toast.LENGTH_LONG).show();

                                    }


                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                });
                builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });
                builder.show();

            }
        });

        Button btn2= (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(MainActivity.this,CalisanGiris.class);
                startActivity(intent2);

            }
        });

    }
}

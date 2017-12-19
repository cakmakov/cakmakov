package com.example.taskmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GorevTanimlama extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorev_tanimlama);

        Intent intent6 = getIntent();

        final FirebaseDatabase db = FirebaseDatabase.getInstance();


        final EditText edt1 = (EditText)findViewById(R.id.gorevEklemeEkrani);
        final Spinner spinnerCalisan = (Spinner)findViewById(R.id.spinner);



        Button btn = (Button)findViewById(R.id.butonEkle);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String calisan = spinnerCalisan.getSelectedItem().toString();
                String gorev = edt1.getText().toString();


                DatabaseReference dbRef = db.getReference("Tasks");
                String key = dbRef.push().getKey();
                DatabaseReference dbRefKeyli = db.getReference("Tasks/"+key);

                dbRefKeyli.setValue(new Ekle(key,calisan,gorev));

                AlertDialog.Builder bildirim = new AlertDialog.Builder(GorevTanimlama.this);
                bildirim.setTitle("Bildirim");
                bildirim.setMessage("Bilgiler Eklendi.");
                bildirim.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent4 = new Intent(GorevTanimlama.this,Main2Activity.class);
                        startActivity(intent4);

                    }
                });

                AlertDialog dialog = bildirim.create();
                bildirim.show();

            }
        });

    }
}

package com.example.taskmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GorevGuncelleme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorev_guncelleme);

        Intent intent = getIntent();
        final String s2 = intent.getStringExtra(Main2Activity.EXTRA_INFO);

        final FirebaseDatabase db = FirebaseDatabase.getInstance();


        final EditText guncelleEdt = (EditText)findViewById(R.id.gorevGuncellemeEkrani);
        final Spinner guncelleSpinner = (Spinner)findViewById(R.id.spinnerGuncelle);

        Button guncelleBtn = (Button)findViewById(R.id.butonGuncelle);
        guncelleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference ref = db.getInstance().getReference("Tasks");
                ref.getRef().child(s2).setValue(null);

                String calisanGuncelle = guncelleSpinner.getSelectedItem().toString();
                String gorevGuncelle = guncelleEdt.getText().toString();

                DatabaseReference reference = db.getReference("Tasks/"+s2);
                reference.setValue(new Ekle(s2,calisanGuncelle,gorevGuncelle));

                AlertDialog.Builder guncelleBildirim = new AlertDialog.Builder(GorevGuncelleme.this);
                guncelleBildirim.setTitle("Bildirim");
                guncelleBildirim.setMessage("Bilgiler Güncellendi.");
                guncelleBildirim.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(GorevGuncelleme.this,Main2Activity.class);
                        startActivity(intent);

                    }
                });

                AlertDialog dialog = guncelleBildirim.create();
                guncelleBildirim.show();


            }
        });
    }
}

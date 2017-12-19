package com.example.taskmanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CalisanGiris extends AppCompatActivity {

    public static String EXTRA_INFO = "com.example.taskmanager.INFO";
    String kullaniciAdi,kullaniciSifre;
    String c;
    FirebaseAuth mAuth;
    Spinner spnnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calisan_giris);

        spnnr = (Spinner)findViewById(R.id.spinner2);
        final EditText editText1 = (EditText)findViewById(R.id.editText1);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if (firebaseUser != null){

            Intent intent = new Intent(CalisanGiris.this,Main3Activity.class);
            startActivity(intent);

        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kullaniciAdi = editText1.getText().toString().trim();
                kullaniciSifre = editText2.getText().toString().trim();
                if (kullaniciAdi.isEmpty() || kullaniciSifre.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen Gerekli Alanları Doldurunuz.",Toast.LENGTH_SHORT).show();

                }else {

                    Login();

                }

            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(CalisanGiris.this,KayitEkrani.class);
                startActivity(intent2);

            }
        });

    }

    private void Login(){

        mAuth.signInWithEmailAndPassword(kullaniciAdi,kullaniciSifre).addOnCompleteListener(CalisanGiris.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    c = spnnr.getSelectedItem().toString();
                    EXTRA_INFO = "";
                    Intent intent3 = new Intent(CalisanGiris.this,Main3Activity.class);
                    intent3.putExtra(EXTRA_INFO,c);
                    startActivity(intent3);

                }else {

                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}

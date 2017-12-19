package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class KayitEkrani extends AppCompatActivity {

    String kullaniciAdi,kullaniciSifre;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);

        final EditText editText1 = (EditText)findViewById(R.id.editText1);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        Button button1 = (Button)findViewById(R.id.button1);

        mAuth = FirebaseAuth.getInstance();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kullaniciAdi = editText1.getText().toString().trim();
                kullaniciSifre = editText2.getText().toString().trim();
                if (kullaniciAdi.isEmpty() || kullaniciSifre.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen Gerekli Alanları Doldurunuz.",Toast.LENGTH_SHORT).show();

                }else {

                    Kayit();

                }

            }
        });

    }

    private void Kayit(){

        mAuth.createUserWithEmailAndPassword(kullaniciAdi,kullaniciSifre).addOnCompleteListener(KayitEkrani.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Intent intent = new Intent(KayitEkrani.this,Main3Activity.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}

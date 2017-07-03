package com.gycell.acilis_ekrani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class bilgiGosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi_goster);

        Intent intent = getIntent();
        String userInfo = intent.getStringExtra(MainActivity.EXTRA_INFO);
        String passInfo = intent.getStringExtra(MainActivity.EXTRA_INFO);
        String identityNo = intent.getStringExtra(MainActivity.EXTRA_INFO);

        TextView textView1 =(TextView) findViewById(R.id.userName);
        TextView textView2 =(TextView) findViewById(R.id.password);
        TextView textView3 =(TextView) findViewById(R.id.identity);

        textView1.setText(userInfo);
        textView2.setText(passInfo);
        textView3.setText(identityNo);

    }
}

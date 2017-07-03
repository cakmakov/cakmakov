package com.gycell.wired;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Makale3 extends AppCompatActivity {

    private static String URL = "https://www.wired.com/2017/05/defense-reality-time/";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makale3);
        ScrollView scrollView = (ScrollView)findViewById(R.id.scroll);

        Intent intent = getIntent();

        new VeriGetir().execute();
    }

    private class VeriGetir extends AsyncTask {

        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(Makale3.this);
            progressDialog.setTitle("AÇIKLAMA");
            progressDialog.setMessage("Lütfen Bekleyiniz...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }

        @Override
        protected Object doInBackground(Object[] params) {

            try {
                Document doc = Jsoup.connect(URL).timeout(30 * 1000).get();

                Elements elements = doc.select("article[data-js=content]");
                desc = elements.text();


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);


            TextView textView = (TextView) findViewById(R.id.makale3);
            textView.setText("Açıklama: " + "" + desc);
            progressDialog.dismiss();
        }
    }
}

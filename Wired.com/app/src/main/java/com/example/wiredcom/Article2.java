package com.example.wiredcom;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Article2 extends AppCompatActivity {


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article2);

        ScrollView scrollView = (ScrollView)findViewById(R.id.scroll);

        new artcl2().execute();
    }

    public class artcl2 extends AsyncTask {

        String article;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(Article2.this);
            progressDialog.setTitle("Notification");
            progressDialog.setMessage("Please Wait...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }

        @Override
        public Object doInBackground(Object[] params) {

            try {

                Intent intent = getIntent();
                String url = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
                String URL = "https://www.wired.com"+url;
                Document doc = Jsoup.connect(URL).timeout(30*1000).get();
                Elements elements1 = doc.select("main[class=article-main-component__content]");
                if (elements1.toString().equals("")){

                    Elements elements2 = doc.select("article[data-js=content]");
                    article = elements2.text();

                }else {

                    article=elements1.text();

                }




            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);


            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(article);

            Button button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int count = 1;
                    for (int i=0;i<=article.length()-1;i++)
                    {
                        if (article.charAt(i) == ' ' && article.charAt(i+1)!=' ')
                        {
                            count++;
                        }
                    }



                    AlertDialog.Builder builder = new AlertDialog.Builder(Article2.this);
                    builder.setTitle("Notification");
                    builder.setMessage("Kelime Sayısı: " + count);
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {



                        }
                    });

                    builder.show();

                }
            });


            progressDialog.dismiss();

        }
    }
}

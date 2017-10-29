package com.example.wiredcom;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE1 = "com.example.wiredcom.MESAJ";
    public final static String EXTRA_MESSAGE2 = "com.example.wiredcom.MESAJ";
    public final static String EXTRA_MESSAGE3 = "com.example.wiredcom.MESAJ";
    public final static String EXTRA_MESSAGE4 = "com.example.wiredcom.MESAJ";
    public final static String EXTRA_MESSAGE5 = "com.example.wiredcom.MESAJ";
    private static String URL = "https://www.wired.com/most-recent/";
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new TitleFetch().execute();
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.refreshItem:

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public class TitleFetch extends AsyncTask {


        String title1;
        String title2;
        String title3;
        String title4;
        String title5;
        String desc1;
        String desc2;
        String desc3;
        String desc4;
        String desc5;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Notification");
            progressDialog.setMessage("Please Wait...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

        }

        @Override
        public Object doInBackground(Object[] params) {

            try {
                Document doc = Jsoup.connect(URL).get();
                Elements elements1 = doc.select("h2[data-reactid=159]");
                Elements elements2 = doc.select("h2[data-reactid=180]");
                Elements elements3 = doc.select("h2[data-reactid=201]");
                Elements elements4 = doc.select("h2[data-reactid=222]");
                Elements elements5 = doc.select("h2[data-reactid=243]");
                title1 = elements1.text();
                title2 = elements2.text();
                title3 = elements3.text();
                title4 = elements4.text();
                title5 = elements5.text();
                Elements elements6 = doc.select("a[data-reactid=158]");
                desc1 = elements6.attr("href");
                Elements elements7 = doc.select("a[data-reactid=179]");
                desc2 = elements7.attr("href");
                Elements elements8 = doc.select("a[data-reactid=200]");
                desc3 = elements8.attr("href");
                Elements elements9 = doc.select("a[data-reactid=221]");
                desc4 = elements9.attr("href");
                Elements elements10 = doc.select("a[data-reactid=242]");
                desc5 = elements10.attr("href");


            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);


            String[] articles = {title1, title2, title3, title4, title5};

            ListView articleList = (ListView) findViewById(R.id.list);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, articles);
            articleList.setAdapter(adapter);

            articleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                    if (position == 0) {

                        Intent intent1 = new Intent(MainActivity.this, Article1.class);
                        String url = desc1;
                        intent1.putExtra(EXTRA_MESSAGE1, url);
                        startActivity(intent1);

                    } else if (position == 1) {

                        Intent intent2 = new Intent(MainActivity.this, Article2.class);
                        String url = desc2;
                        intent2.putExtra(EXTRA_MESSAGE2, url);
                        startActivity(intent2);

                    } else if (position == 2) {

                        Intent intent3 = new Intent(MainActivity.this, Article3.class);
                        String url = desc3;
                        intent3.putExtra(EXTRA_MESSAGE3, url);
                        startActivity(intent3);

                    } else if (position == 3) {

                        Intent intent4 = new Intent(MainActivity.this, Article4.class);
                        String url = desc4;
                        intent4.putExtra(EXTRA_MESSAGE4, url);
                        startActivity(intent4);

                    } else if (position == 4) {

                        Intent intent5 = new Intent(MainActivity.this, Article5.class);
                        String url = desc5;
                        intent5.putExtra(EXTRA_MESSAGE5, url);
                        startActivity(intent5);

                    }

                }

            });

            progressDialog.dismiss();

        }


    }

}


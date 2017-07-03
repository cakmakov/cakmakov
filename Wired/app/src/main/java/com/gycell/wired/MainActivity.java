package com.gycell.wired;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] makaleler = {"While You Were Offline: Trump Says He’s Treated Unfairly. Abe Lincoln Like, ‘What?’", "Get Ready for the Next Big Privacy Backlash Against Facebook", "In Defense of the Reality of Time", "Shoot 360 Video Like a Pro in 6 Simple Steps", "Prepare Yourself for the Sweet, Sweet Luxury of Riding in a Robocar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listemiz = (ListView) findViewById(R.id.liste);
        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, makaleler);
        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                if (position == 0){

                    Intent intent1 = new Intent(MainActivity.this,Makale1.class);
                    startActivity(intent1);

                }
                else if (position == 1){

                    Intent intent2 = new Intent(MainActivity.this,Makale2.class);
                    startActivity(intent2);

                }else if (position == 2){

                    Intent intent3 = new Intent(MainActivity.this,Makale3.class);
                    startActivity(intent3);

                }else if (position == 3){

                    Intent intent4 = new Intent(MainActivity.this,Makale4.class);
                    startActivity(intent4);

                }else if (position == 4){

                    Intent intent5 = new Intent(MainActivity.this,Makale5.class);
                    startActivity(intent5);

                }

            }

        });
    }

}


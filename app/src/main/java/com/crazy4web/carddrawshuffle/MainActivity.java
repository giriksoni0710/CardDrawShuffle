package com.crazy4web.carddrawshuffle;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    public class Card
    {
        private int type, value;
        private String[] cardType = {"clubs", "spades", "diamonds", "hearts"};
        private String[] cardValue = {"ace", "king", "queen", "jack", "ten",
                "nine", "eight", "seven", "six", "five", "four", "three", "two"};

        public Card(int types, int values)
        {
            type = types;
            value = values;
        }

        public String toString()
        {
            String finalCard = cardValue[value] + "_of_" + cardType[type];

            return finalCard;
        }
    }

    ArrayList<String> arr= new ArrayList<String>();
    Card abc;
    int count=51;
    int deck=1;
    TextView text,text2;
    ImageView img;
    String imgsrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                text = (TextView) findViewById(R.id.textView);
                text2 = (TextView) findViewById(R.id.text4);
                img = (ImageView) findViewById(R.id.imageView);

                while(deck==1){
                for(int i=0;i<4;i++) {
                    for (int j = 0; j < 13; j++) {

                        abc = new Card(i, j);

                        arr.add(abc.toString());

                    }
                }
                    deck--;
                Collections.shuffle(arr);
                }

                if(count==0){

                    count=52;

                    text2.setText(""+(count+1));

                    img.setImageResource(R.drawable.black_joker);
                }

                if(count>0) {

                    text2.setText(String.valueOf(count));
                }

                if(count==51){

                    Collections.shuffle(arr);
                    text.setText(""+(count+1));

                    img.setImageResource(R.drawable.black_joker);
                }



               if(count!=52) {
                    text.setText(arr.get(count));

                    Log.d("image",""+arr.get(count));

                    int id = getApplicationContext().getResources().getIdentifier(""+arr.get(count), "drawable", getApplicationContext().getPackageName());

                    img.setImageResource(id);

                    Log.d("id2",""+id);
               }
                count--;
            }
        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Collections.shuffle(arr);
            count=51;
            text2.setText(""+(count+1));

            img.setImageResource(R.drawable.black_joker);

         }

        return super.onOptionsItemSelected(item);
    }
}

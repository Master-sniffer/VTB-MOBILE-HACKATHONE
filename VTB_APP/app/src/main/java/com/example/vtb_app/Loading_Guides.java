package com.example.vtb_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Loading_Guides extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_output);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.news_view);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        Guides fonds = new Guides("Фонды","1 Уровень",
                "drawable://" + R.drawable.dark1);
        Guides stocks = new Guides("Акции","3 Уровень",
                "drawable://" + R.drawable.dark1);
        Guides obligations = new Guides("Облигации","2 Уровень",
                "drawable://" + R.drawable.dark1);





        //Add the Person objects to an ArrayList
        ArrayList<Guides> stock_market = new ArrayList<>();
        stock_market.add(fonds);
        stock_market.add(obligations);
        stock_market.add(stocks);




        Guides_List_Adapter adapter = new Guides_List_Adapter(this, R.layout.content_output, stock_market);
        mListView.setAdapter(adapter);
    }
}

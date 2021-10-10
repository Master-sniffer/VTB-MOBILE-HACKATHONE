package com.example.vtb_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Naviagor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigator);
    }


    public void Poihali (View view){
        System.out.println("WORK IN PROGRESS...");
    }

    public void Home (View view){
        Intent myIntent = new Intent(view.getContext(), MainPaige.class);
        startActivity(myIntent);
    }
    public void lessons (View view){
        Intent myIntent = new Intent(view.getContext(), Lessons.class);
        startActivity(myIntent);
    }
    public void profile (View view){
        Intent myIntent = new Intent(view.getContext(), Profile.class);
        startActivity(myIntent);
    }
}

package com.example.vtb_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import From_Down_Below.ExampleButtonSheet;

public class Error extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);

    }

    public void perenos (View view){
        Intent myIntent = new Intent(view.getContext(), MainPaige.class);
        startActivity(myIntent);
    }

}

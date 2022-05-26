package com.example.vtb_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import From_Down_Below.ExampleButtonSheet;

public class MainPaige extends AppCompatActivity implements ExampleButtonSheet.BottomSheetListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_paige);

    }

    public void Vse_Ravno(View view){
        Intent myIntent = new Intent(view.getContext(), Error.class);
        startActivity(myIntent);

    }

    public void Stat_Clientom(View view){
        Intent myIntent = new Intent(view.getContext(), MakeClient.class);
        startActivity(myIntent);
    }

    @Override
    public void onButtonClicked(String text) {
        System.out.println(text);
    }
}

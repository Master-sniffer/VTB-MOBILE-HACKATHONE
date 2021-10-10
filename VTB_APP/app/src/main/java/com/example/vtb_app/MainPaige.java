package com.example.vtb_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import From_Down_Below.ExampleButtonSheet;

public class MainPaige extends AppCompatActivity implements ExampleButtonSheet.BottomSheetListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_item_view);



    }

    public void Vse_Ravno(View view){
        Intent myIntent = new Intent(view.getContext(), Error.class);
        startActivity(myIntent);

    }

    public void Stat_Clientom(View view){
        Intent myIntent = new Intent(view.getContext(), Lessons.class);
        startActivity(myIntent);
//        ExampleButtonSheet bottom_sheet = new ExampleButtonSheet();
//        bottom_sheet.show(getSupportFragmentManager(), "example bottom sheet");


    }

    @Override
    public void onButtonClicked(String text) {
        System.out.println(text);
    }
}

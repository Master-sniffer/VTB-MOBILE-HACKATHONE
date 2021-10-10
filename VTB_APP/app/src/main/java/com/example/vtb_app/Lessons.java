package com.example.vtb_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import From_Down_Below.ExampleButtonSheet;

public class Lessons extends AppCompatActivity implements ExampleButtonSheet.BottomSheetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessonsss);
    }

    public void Navigator (View view){
        Intent myIntent = new Intent(view.getContext(), Naviagor.class);
        startActivity(myIntent);
    }
    public void Home (View view){
        Intent myIntent = new Intent(view.getContext(), MainPaige.class);
        startActivity(myIntent);
    }
    public void profile (View view){
        Intent myIntent = new Intent(view.getContext(), Profile.class);
        startActivity(myIntent);
    }

    public void First_Steps(View view){
        ExampleButtonSheet bottom_sheet = new ExampleButtonSheet();
        bottom_sheet.show(getSupportFragmentManager(), "example bottom sheet");

    }

    @Override
    public void onButtonClicked(String text) {
        System.out.println(text);
    }
}

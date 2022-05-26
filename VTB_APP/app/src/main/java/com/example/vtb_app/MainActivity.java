package com.example.vtb_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.view.View;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

//    private EditText EnterText;
//    private Button button_acpt;
//    private TextView View_Result;
//    private Word_Adaptation word_adaptation;

    SharedPreferences.Editor myEditor;
    SharedPreferences myPreferences;
    public float water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        myEditor = myPreferences.edit();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //NEED THIS TO CHECK OUR DB
        DataBase dataBase = null;
        try {
            dataBase = new DataBase();
            dataBase.getAllUsers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void UzheClient(View view){
        Intent myIntent = new Intent(view.getContext(), Lesson_Page.class);
        startActivity(myIntent);
    }

    public void Nachat (View view){

        Intent myIntent = new Intent(view.getContext(), MainPaige.class);
        startActivity(myIntent);
    }
}
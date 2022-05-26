package com.example.vtb_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        textView = findViewById(R.id.textView11);
        textView.setText("Добро пожаловать, "+MakeClient.name.getText());

    }


    public void Home (View view){
        Intent myIntent = new Intent(view.getContext(), MainPaige.class);
        startActivity(myIntent);
    }
    public void lessons (View view){
        Intent myIntent = new Intent(view.getContext(), Lesson_Page.class);
        startActivity(myIntent);
    }
    public void navigator (View view){
        Intent myIntent = new Intent(view.getContext(), Naviagor.class);
        startActivity(myIntent);
    }

    public void Open_Vtb (View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.vtb24.mobilebanking.android&hl=ru&gl=US"));
        startActivity(browserIntent);
    }

    public void uznat_Recommend (View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vtb.ru/personal/vklady-i-scheta/nakopitelny-schet-kopilka/"));
        startActivity(browserIntent);
    }

}

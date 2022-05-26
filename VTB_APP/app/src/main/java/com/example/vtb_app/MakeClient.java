package com.example.vtb_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class MakeClient extends AppCompatActivity {

    public static EditText name;
    EditText email;
    TextView EnterEmailAndName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_client);
        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        EnterEmailAndName = findViewById(R.id.EnterEmailAndName);
    }

    public void SignIn(View view) throws SQLException {
        DataBase db = new DataBase();
        boolean respond = db.putUser(email.getText().toString().toLowerCase(), name.getText().toString().toLowerCase());
        if (respond){
            Intent myIntent = new Intent(view.getContext(), Lesson_Page.class);
            Toast.makeText(getApplicationContext(), "Welcome, "+name.getText(), Toast.LENGTH_SHORT).show();
            startActivity(myIntent);
        } else{
            Toast.makeText(getApplicationContext(), "Something went wrong... Maybe try logging in ?", Toast.LENGTH_SHORT).show();
            name.setText("");
            email.setText("");
        }

    }
}
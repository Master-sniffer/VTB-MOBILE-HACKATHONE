package com.example.vtb_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText EnterText;
    private Button button_acpt;
    private TextView View_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterText = findViewById(R.id.EnterText);
        button_acpt = findViewById(R.id.button_acpt);
        View_Result = findViewById(R.id.View_Result);

        button_acpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EnterText.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, R.string.No_User_Input, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
package com.example.vtb_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import Word_Adapter.Word_Adaptation;

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


//        EnterText = findViewById(R.id.EnterText);
//        button_acpt = findViewById(R.id.button_acpt);
//        View_Result = findViewById(R.id.View_Result);
//
//        word_adaptation = new Word_Adaptation();
//
//        List<Word> words = getWords();
//        word_adaptation.SetWords(words);
//
//
//        button_acpt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (EnterText.getText().toString().trim().equals("")){
//                    Toast.makeText(MainActivity.this, R.string.No_User_Input, Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }

    public void UzheClient(View view){
        myEditor.putFloat("Water", water+=1);
        myEditor.commit();
    }

    public void Nachat (View view){
         water = (myPreferences.getFloat("Water", 0));
         System.out.println(water);
    }

//    private List<Word>  getWords() {
//        return Arrays.asList(
//                new Word("Мать", "Mother"),
//                new Word("Отец", "Batya")
//        );
//    }
}
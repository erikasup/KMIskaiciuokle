package com.example.kmiskaiciuokle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ugisEditText;
    EditText svorisEditText;
    Button button;


    @Override
    protected void onResume() {
        super.onResume();



        String ugis = PreferenceManager.getDefaultSharedPreferences(this).getString("ugis", "0");
        String svoris = PreferenceManager.getDefaultSharedPreferences(this).getString("svoris", "0");
        ugisEditText.setText(ugis);
        svorisEditText.setText(svoris);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ugisEditText = findViewById(R.id.ugisEditText);
        svorisEditText = findViewById(R.id.svorisEditText);
        button = findViewById(R.id.button);




        //button = kintamasis button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
    }

    public void onButtonClick (View v){
        String sugis  = ugisEditText.getText().toString(); //sugis = string ugis

        double ugis = Double.parseDouble(sugis) / 100; //naudojam double, kad butu po kablelio
        double svoris = Double.parseDouble(svorisEditText.getText().toString());//

        double kmi = svoris / (ugis * ugis); //formule rezultatui gauti

        Intent intent = new Intent(MainActivity.this, Rezultatas.class);// perkelia is main i rezultatas activity
        intent.putExtra("kmi", kmi);
        startActivity(intent); // startuoja intent



    }
}


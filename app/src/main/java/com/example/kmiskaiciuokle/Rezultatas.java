package com.example.kmiskaiciuokle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class Rezultatas extends AppCompatActivity {

    TextView kmiTextview;
    TextView aprasasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultatas);
        kmiTextview = findViewById(R.id.kmiTextView);
        aprasasTextView = findViewById(R.id.aprasasTextView);
        rodytiRezultata();

    }

    public void rodytiRezultata() {
        Intent intent = getIntent();
        double kmi = intent.getDoubleExtra("kmi", 0);
        BigDecimal bkmi = new BigDecimal(kmi);
        bkmi = bkmi.setScale(1, BigDecimal.ROUND_HALF_UP);
        String skmi = String.valueOf(bkmi);
        kmiTextview.setText(skmi); //atspausdinam atsakyma

        if (kmi <= 18.5){
            aprasasTextView.setText("Mažas");
            aprasasTextView.setTextColor(Color.BLACK);
        } else {
            if (kmi > 25){
                aprasasTextView.setText("Didelis");
                aprasasTextView.setTextColor(Color.RED);
            } else {
                aprasasTextView.setText("Normalus");
                aprasasTextView.setTextColor(Color.GREEN);
            }
        }
    }
}

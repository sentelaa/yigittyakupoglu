package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class YemekOnerisiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_onerisi);


        String kiloAmaci = getIntent().getStringExtra("kiloAmaci");
        String makro = getIntent().getStringExtra("makro");

        TextView yemekOnerisiText = findViewById(R.id.yemekOnerisiText);

        String oneriler = "";

        if (kiloAmaci.equals("kiloAl")) {
            switch (makro) {
                case "protein":
                    oneriler = "350gr Tavuk veya 400gr Balık";
                    break;
                case "karbonhidrat":
                    oneriler = "400gr Pirinç veya 200gr Fındık Ezmesi";
                    break;
                case "yag":
                    oneriler = "Zeytinyağlı Yemekler";
                    break;
            }
        } else if (kiloAmaci.equals("kiloVer")) {
            switch (makro) {
                case "protein":
                    oneriler = "200gr Tavuk veya 4 Haşlanmış Yumurta";
                    break;
                case "karbonhidrat":
                    oneriler = "200gr Pirinç veya 100gr Yulaf";
                    break;
                case "yag":
                    oneriler = "30gr Fındık veya 30gr Ceviz";
                    break;
            }
        }


        yemekOnerisiText.setText("Önerilen Yemekler: \n" + oneriler);
    }


}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MakroSecimiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makro_secimi);

        String kiloAmaci = getIntent().getStringExtra("kiloAmaci");

        Button proteinButton = findViewById(R.id.proteinButton);
        Button karbonhidratButton = findViewById(R.id.karbonhidratButton);
        Button yagButton = findViewById(R.id.yagButton);
        Button geriButton = findViewById(R.id.geriButton);

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakroSecimiActivity.this, YemekOnerisiActivity.class);
                intent.putExtra("kiloAmaci", kiloAmaci);
                intent.putExtra("makro", "protein");
                startActivity(intent);
            }
        });

        karbonhidratButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakroSecimiActivity.this, YemekOnerisiActivity.class);
                intent.putExtra("kiloAmaci", kiloAmaci);
                intent.putExtra("makro", "karbonhidrat");
                startActivity(intent);
            }
        });

        yagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakroSecimiActivity.this, YemekOnerisiActivity.class);
                intent.putExtra("kiloAmaci", kiloAmaci);
                intent.putExtra("makro", "yag");
                startActivity(intent);
            }
        });

        geriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

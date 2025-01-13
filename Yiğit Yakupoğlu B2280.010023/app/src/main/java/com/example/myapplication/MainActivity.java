package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kiloAlButton = findViewById(R.id.kiloAlButton);
        Button kiloVerButton = findViewById(R.id.kiloVerButton);

        kiloAlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakroSecimiActivity.class);
                intent.putExtra("kiloAmaci", "kiloAl");
                startActivity(intent);
            }
        });

        kiloVerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakroSecimiActivity.class);
                intent.putExtra("kiloAmaci", "kiloVer");
                startActivity(intent);
            }
        });
    }
}



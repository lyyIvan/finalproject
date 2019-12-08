package com.example.finalprojectavg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newgame = findViewById(R.id.newgame);
        //final Intent jump = new Intent(this, gamePlayPage.class);
        newgame.setOnClickListener(unused-> {
            Intent jump = new Intent(this, gameplaypage.class);
            startActivity(jump);
            //finish();
        });

    }
}

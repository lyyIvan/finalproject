package com.example.finalprojectavg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class finale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finale);
        TextView end = findViewById(R.id.result);
        int score = getIntent().getIntExtra("score", 0);
        if (score > 400) {
            end.setText("You won! You had overcome the so-called challenge! With your efforts, most of your body broke through the ground. But at the same time, you were too tired and you quickly lost consciousness.\n\n\nAfter a few days, you woke up from hospital bed. Looking at everything around you, you couldn’t believe everything has passed. You stayed in the hospital for a few more days, and then you returned home, only to find that your wife was not at home. Just when you were wondering about it, the phone rang, and you answered the phone. You just heard the opposite side said in a strange and familiar voice: \"Do you miss me?\"");
        } else {
            end.setText("You were unfortunately overwhelmed by a larger piece of mudstone, and buried in despair by the influx of sand.");
        }
    }
}

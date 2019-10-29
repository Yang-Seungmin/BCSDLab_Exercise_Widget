package com.yangseungmin.bcsdlab_exercise_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private TextView textViewDescription, textViewRandomCount;
    private int maxRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        if (getIntent() != null) {
            maxRandomNumber = getIntent().getIntExtra("random", -1);
        }
        init();
        textViewDescription.setText("Here is a random number between 0 and " + maxRandomNumber);
        textViewRandomCount.setText(String.valueOf(getRandomNumber(maxRandomNumber)));
    }

    private void init() {
        textViewDescription = findViewById(R.id.textView_description);
        textViewRandomCount = findViewById(R.id.textView_random_number);
    }

    public int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }
}

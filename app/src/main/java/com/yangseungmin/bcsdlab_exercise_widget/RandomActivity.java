package com.yangseungmin.bcsdlab_exercise_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private TextView textViewDescription, textViewRandomCount;
    private Intent intent;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        init();

        intent = getIntent();
        random = new Random();
        textViewDescription.setText("Here is a random number between 0 and " + String.valueOf(intent.getExtras().getInt("random")));
        textViewRandomCount.setText(String.valueOf(random.nextInt(intent.getExtras().getInt("random") + 1)));
    }

    private void init() {
        textViewDescription = (TextView) findViewById(R.id.textView_description);
        textViewRandomCount = (TextView) findViewById(R.id.textView_random_number);
    }
}

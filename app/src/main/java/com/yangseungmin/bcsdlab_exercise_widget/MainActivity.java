package com.yangseungmin.bcsdlab_exercise_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toastButton, countButton;
    private TextView textView;

    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        toastButton.setOnClickListener(this);
        countButton.setOnClickListener(this);

        textView.setText(String.valueOf(count));
    }

    private void init() {
        toastButton = (Button) findViewById(R.id.button_toast);
        countButton = (Button) findViewById(R.id.button_count);

        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_toast:
                Toast.makeText(this, "Toast Example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_count:
                textView.setText(String.valueOf(++count));
                break;
        }
    }
}

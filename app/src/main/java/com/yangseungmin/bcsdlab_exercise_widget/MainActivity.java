package com.yangseungmin.bcsdlab_exercise_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonIncreaseCount;

    private TextView textView;

    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        buttonIncreaseCount = (Button) findViewById(R.id.button_increase_count);
        buttonIncreaseCount.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_increase_count:
                count++;
                textView.setText(String.valueOf(count));
                break;
        }
    }
}

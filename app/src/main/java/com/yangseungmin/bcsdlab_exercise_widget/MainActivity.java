package com.yangseungmin.bcsdlab_exercise_widget;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toastButton, randomButton;
    private ImageButton countButton;
    private TextView textView;
    private Context context;
    private static int count = 0;

    private boolean isFragmentOpened = false;
    private RandomFragment randomFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        init();

        textView.setText(String.valueOf(count));
    }

    private void init() {
        toastButton = findViewById(R.id.button_toast);
        countButton = findViewById(R.id.button_count);
        randomButton = findViewById(R.id.button_random);
        toastButton.setOnClickListener(this);
        countButton.setOnClickListener(this);
        randomButton.setOnClickListener(this);

        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_toast:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Dialog");
                builder.setMessage("You just activated my trap card.");
                builder.setPositiveButton("Reset count", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        count = 0;
                        textView.setText(String.valueOf(count));
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.setNeutralButton("Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Toast Example", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                break;
            case R.id.button_count:
                textView.setText(String.valueOf(++count));
                break;
            case R.id.button_random:

                if(!isFragmentOpened) {
                    randomFragment = new RandomFragment(count);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.fragment_container, randomFragment).commit();
                    isFragmentOpened = true;
                }

                /*Intent intent = new Intent(context, RandomActivity.class);
                intent.putExtra("random", count);
                startActivity(intent);*/
        }
    }

    @Override
    public void onBackPressed() {
        if(isFragmentOpened) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.detach(randomFragment).commit();
            isFragmentOpened = false;
        } else super.onBackPressed();
    }
}

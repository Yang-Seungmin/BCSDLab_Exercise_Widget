package com.yangseungmin.bcsdlab_exercise_widget;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {

    private TextView textViewDescription, textViewRandomCount;
    private int maxRandomNumber;

    public RandomFragment(int count) {
        // Required empty public constructor
        this.maxRandomNumber = count;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        init(view);

        textViewDescription.setText("Here is a random number between 0 and " + maxRandomNumber);
        textViewRandomCount.setText(String.valueOf(getRandomNumber(maxRandomNumber)));

        return view;
    }

    private void init(View view) {
        textViewDescription = view.findViewById(R.id.textView_description);
        textViewRandomCount = view.findViewById(R.id.textView_random_number);
    }

    public int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }

}

package com.yangseungmin.bcsdlab_exercise_widget;

import android.content.Intent;
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
    private int maxRandomNumber, randomNumber;
    private Intent intent;

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
        randomNumber = getRandomNumber(maxRandomNumber);
        textViewRandomCount.setText(String.valueOf(randomNumber));

        startNotificationService();

        return view;
    }

    private void startNotificationService() {
        intent = new Intent(getActivity(), NotificationService.class);
        intent.putExtra("max", maxRandomNumber);
        intent.putExtra("val", randomNumber);
        getActivity().startService(intent);
    }

    private void init(View view) {
        textViewDescription = view.findViewById(R.id.textView_description);
        textViewRandomCount = view.findViewById(R.id.textView_random_number);
    }

    public int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().stopService(intent);
    }
}

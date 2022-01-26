package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int team1 = 0;
    private int team2 = 0;
    private TextView team1Score;
    private TextView team2Score;
    private ImageButton team1plus;
    private ImageButton team1minus;
    private ImageButton team2plus;
    private ImageButton team2minus;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    /**
     * Handles the onClick of both the decrement buttons.
     *
     * @param view The button view that was clicked
     */
    public void decreaseScore(View view) {
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            // If it was on Team 1:
            case R.id.team1minus:
                // Decrement the score and update the TextView.
                team1--;
                team1Score.setText(String.valueOf(team1));
                break;
            // If it was Team 2:
            case R.id.team2minus:
                // Decrement the score and update the TextView.
                team2--;
                team2Score.setText(String.valueOf(team2));
        }
    }

    /**
     * Handles the onClick of both the increment buttons.
     *
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            // If it was on Team 1:
            case R.id.team1plus:
                // Increment the score and update the TextView.
                team1++;
                team1Score.setText(String.valueOf(team1));
                break;
            // If it was Team 2:
            case R.id.team2plus:
                // Increment the score and update the TextView.
                team2++;
                team2Score.setText(String.valueOf(team2));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("team1Score", team1);
        outState.putInt("team2Score", team2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team1plus = findViewById(R.id.team1plus);
        team2plus = findViewById(R.id.team2plus);
        team1minus = findViewById(R.id.team1minus);
        team2minus = findViewById(R.id.team2minus);
        team1Score = findViewById(R.id.team1score);
        team2Score = findViewById(R.id.team2score);
        if (savedInstanceState != null) {
            team1 = savedInstanceState.getInt("team1Score");
            team2 = savedInstanceState.getInt("team2Score");
            team1Score.setText(Integer.toString(team1));
            team2Score.setText(Integer.toString(team2));
        }
    }
}
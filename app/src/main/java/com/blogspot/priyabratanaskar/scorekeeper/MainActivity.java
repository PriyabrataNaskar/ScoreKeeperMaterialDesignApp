package com.blogspot.priyabratanaskar.scorekeeper;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";
    private int teamOneScore;
    private int teamTwoScore;
    private TextView teamOneTextView;
    private TextView teamTwoTextView;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, teamOneScore);
        outState.putInt(STATE_SCORE_2, teamTwoScore);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamOneTextView = findViewById(R.id.score_1);
        teamTwoTextView = findViewById(R.id.score_2);
        if (savedInstanceState != null) {
            teamOneScore = savedInstanceState.getInt(STATE_SCORE_1);
            teamTwoScore = savedInstanceState.getInt(STATE_SCORE_2);

            teamOneTextView.setText(String.valueOf(teamOneScore));
            teamTwoTextView.setText(String.valueOf(teamTwoScore));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e("MainActivity","onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.e("MainActivity","onOptionsItemSelected");
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        }
        return true;
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decrease_button_team1:
                teamOneScore--;
                teamOneTextView.setText(String.valueOf(teamOneScore));
                break;
            case R.id.decrease_button_team2:
                teamTwoScore--;
                teamTwoTextView.setText(String.valueOf(teamTwoScore));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.increase_button_team1:
                teamOneScore++;
                teamOneTextView.setText(String.valueOf(teamOneScore));
                break;
            case R.id.increase_button_team2:
                teamTwoScore++;
                teamTwoTextView.setText(String.valueOf(teamTwoScore));
                break;
        }
    }
}
package com.example.android.projectscorekeeperapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Team A variables
     */
    int team_a_score = 0;
    int team_a_strike = 0;
    int team_a_ball = 0;
    int team_a_out = 0;

    /**
     * Team B variables
     */
    int team_b_score = 0;
    int team_b_strike = 0;
    int team_b_ball = 0;
    int team_b_out = 0;

    int gameInning = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This displays the current inning by coloring the boxes blue
     * and resets the gameInning to 1 if the game reaches the last inning
     **/
    public void displayInning() {

        TextView textView1 = (TextView) findViewById(R.id.one);
        TextView textView2 = (TextView) findViewById(R.id.two);
        TextView textView3 = (TextView) findViewById(R.id.three);
        TextView textView4 = (TextView) findViewById(R.id.four);
        TextView textView5 = (TextView) findViewById(R.id.five);
        TextView textView6 = (TextView) findViewById(R.id.six);
        TextView textView7 = (TextView) findViewById(R.id.seven);
        TextView textView8 = (TextView) findViewById(R.id.eight);
        TextView textView9 = (TextView) findViewById(R.id.nine);
        TextView textView10 = (TextView) findViewById(R.id.ten);
        TextView textView11 = (TextView) findViewById(R.id.eleven);
        TextView textView12 = (TextView) findViewById(R.id.twelve);
        TextView textView13 = (TextView) findViewById(R.id.thirteen);
        TextView textView14 = (TextView) findViewById(R.id.fourteen);
        TextView textView15 = (TextView) findViewById(R.id.fifteen);
        TextView textView16 = (TextView) findViewById(R.id.sixteen);
        TextView textView17 = (TextView) findViewById(R.id.seventeen);
        TextView textView18 = (TextView) findViewById(R.id.eighteen);


        TextView[] textViews = new TextView[]{textView1, textView2, textView3, textView4,
                textView5, textView6, textView7, textView8, textView9, textView10, textView11,
                textView12, textView13, textView14, textView15, textView16, textView17, textView18};

        if (gameInning < 18) {
            TextView scoreView = textViews[gameInning - 1];
            scoreView.setBackgroundColor(Color.parseColor("#2196F3"));
        } else {
            reset();
            gameInning = 1;
            for (TextView text : textViews) {
                text.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
            textViews[0].setBackgroundColor(Color.parseColor("#2196F3"));
        }
    }

    /**
     * This displays a message to let the user know who's turn it is to play
     **/
    public void displayTeamTurn(String score) {
        TextView scoreView = (TextView) findViewById(R.id.teamTurn);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays strikes for Team A
     */
    public void displayStrikeForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_strike);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays strikes for Team B.
     */
    public void displayStrikeForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_strike);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays balls for Team A.
     */
    public void displayBallForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_ball);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays balls for Team B.
     */
    public void displayBallForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_ball);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays outs for Team A.
     */
    public void displayOutForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_out);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays outs for Team B.
     */
    public void displayOutForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_out);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds to score for Team A.
     */
    public void addRunForTeamA(View view) {
        if (gameInning % 2 == 0) {
            displayTeamTurn("It's Team B's Turn!");
            return;
        } else
            team_a_score = team_a_score + 1;
        displayForTeamA(team_a_score);
    }

    /**
     * Adds to score for Team B.
     */
    public void addRunForTeamB(View view) {
        if (gameInning % 2 == 0) {
            team_b_score = team_b_score + 1;
            displayForTeamB(team_b_score);
        } else {
            displayTeamTurn("It's Team A's Turn!");
            return;
        }
    }

    /**
     * Adds to strikes for Team A.
     */
    public void addStrikeForTeamA(View view) {
        if (gameInning % 2 == 0) {
            displayTeamTurn("It's Team B's Turn!");
            return;
        } else {
            if (team_a_strike < 2) {
                team_a_strike = team_a_strike + 1;
                displayStrikeForTeamA(team_a_strike);
            } else {
                team_a_strike = 0;
                team_a_ball = 0;
                displayBallForTeamA(team_a_ball);
                displayStrikeForTeamA(team_a_strike);
                if (team_a_out < 2) {
                    team_a_out = team_a_out + 1;
                    displayOutForTeamA(team_a_out);
                } else {
                    team_a_out = 0;
                    displayOutForTeamA(team_a_out);
                    gameInning = gameInning + 1;
                    displayInning();
                }
            }
        }
    }

    /**
     * Adds to strikes for Team B.
     */
    public void addStrikeForTeamB(View view) {
        if (gameInning % 2 == 0) {
            if (team_b_strike < 2) {
                team_b_strike = team_b_strike + 1;
                displayStrikeForTeamB(team_b_strike);
            } else {
                team_b_strike = 0;
                team_b_ball = 0;
                displayBallForTeamB(team_b_ball);
                displayStrikeForTeamB(team_b_strike);
                if (team_b_out < 2) {
                    team_b_out = team_b_out + 1;
                    displayOutForTeamB(team_b_out);
                } else {
                    team_b_out = 0;
                    displayOutForTeamB(team_b_out);
                    gameInning = gameInning + 1;
                    displayInning();
                }
            }
        } else {
            displayTeamTurn("It's Team A's Turn!");
            return;
        }
    }

    /**
     * Adds to balls for Team A.
     */
    public void addBallForTeamA(View view) {
        if (gameInning % 2 == 0) {
            displayTeamTurn("It's Team B's Turn!");
            return;
        } else {
            if (team_a_ball < 3) {
                team_a_ball = team_a_ball + 1;
                displayBallForTeamA(team_a_ball);
            } else {
                team_a_ball = 0;
                displayBallForTeamA(team_a_ball);
                team_a_score = team_a_score + 1;
                displayForTeamA(team_a_score);
            }
        }
    }

    /**
     * Adds to balls for Team B.
     */
    public void addBallForTeamB(View view) {
        if (gameInning % 2 == 0) {

            if (team_b_ball < 3) {
                team_b_ball = team_b_ball + 1;
                displayBallForTeamB(team_b_ball);
            } else {
                team_b_ball = 0;
                displayBallForTeamB(team_b_ball);
                team_b_score = team_b_score + 1;
                displayForTeamB(team_b_score);
            }
        } else {
            displayTeamTurn("It's Team A's Turn!");
            return;
        }
    }

    /**
     * Resets scores, gameInning, and displayInning, onClick from resetScore comes here, sets
     * the gameInning = 18 to call the else option in displayInning(), then
     * the code from displayInning calls on reset()
     */
    public void resetScores(View view) {
        gameInning = 18;
        displayInning();
    }

    /**
     * Resets all the scores and displays message to user that game was reset
     **/
    private void reset() {
        team_a_score = 0;
        displayForTeamA(team_a_score);
        team_b_score = 0;
        displayForTeamB(team_b_score);
        team_a_strike = 0;
        displayStrikeForTeamA(team_a_strike);
        team_b_strike = 0;
        displayStrikeForTeamB(team_b_strike);
        team_a_ball = 0;
        displayBallForTeamA(team_a_ball);
        team_b_ball = 0;
        displayBallForTeamB(team_b_ball);
        team_a_out = 0;
        displayOutForTeamA(team_a_out);
        team_b_out = 0;
        displayOutForTeamB(team_b_out);
        displayTeamTurn("Game Reset! Team A Start!");
    }
}

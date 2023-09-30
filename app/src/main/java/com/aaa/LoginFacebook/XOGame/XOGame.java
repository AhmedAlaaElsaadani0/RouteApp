
//اسال البشمهندس عنSupressedint annotation
// اسال عن الجذر اللى مش شغال
package com.aaa.LoginFacebook.XOGame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aaa.LoginFacebook.R;

public class XOGame extends AppCompatActivity {

    ConstraintLayout rootView;
    TextView PlayerOneScoreTextView;
    TextView PlayerTwoScoreTextView;
    TextView PlayerOneNameTextView;
    TextView PlayerTwoNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xogame);
        rootView = findViewById(R.id.rooView);
        PlayerOneScoreTextView = findViewById(R.id.PLayerOneScore);
        PlayerTwoScoreTextView = findViewById(R.id.PLayerTwoScore);
        PlayerOneNameTextView = findViewById(R.id.PLayerOneName);
        PlayerTwoNameTextView = findViewById(R.id.PLayerTwoName);
        String Player1Name = getIntent().getStringExtra("Player1Name");
        String Player2Name = getIntent().getStringExtra("Player2Name");
        PlayerOneNameTextView.setText(Player1Name+"(X)");
        PlayerTwoNameTextView.setText(Player2Name+"(O)");

    }

    String[] borderState = {"", "", "",
            "", "", "",
            "", "", ""
    };
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int Counter = 0;
    ColorStateList mainColor;

    @SuppressLint("ResourceAsColor")
    public void onPlayerClick(View V) {
        Button clickedButton = ((Button) V);
        int index = GetIndex(clickedButton);
        if (!clickedButton.getText().toString().isEmpty()) {
            return;
        }
        if (Counter % 2 == 0) {
            clickedButton.setText("X");
            ChangeBorderState(index, "X");
            clickedButton.setBackgroundColor(R.color.black);
            if (!specifyTheWinner("X")) {
                Counter++;
            }

        } else {
            clickedButton.setText("O");
            clickedButton.setBackgroundColor(R.color.mainColor);
            ChangeBorderState(index, "O");
            if (!specifyTheWinner("O"))
                Counter++;


        }
        if (Counter > 8) {
            specifyDrawState();
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean specifyTheWinner(String Symbol) {
        if (checkWinner(Symbol)) {
            if ((Counter % 2 == 0)) {

                playerOneScore += 5;
                PlayerOneScoreTextView.setText("Score: "+playerOneScore );
                Toast.makeText(this, "Player one win", Toast.LENGTH_SHORT).show();
                resetBoard();
                return true;
            } else {
                playerTwoScore += 5;
                Toast.makeText(this, "Player Two win", Toast.LENGTH_SHORT).show();
                PlayerTwoScoreTextView.setText("Score: "+playerTwoScore );
                resetBoard();
                return true;

            }

        }
        return false;

    }

    private void specifyDrawState() {
        resetBoard();
    }

    private void resetBoard() {
        Counter = 0;
        borderState = new String[]{
                "", "", "",
                "", "", "",
                "", "", ""
        };
        clearButtons();
    }

    @SuppressLint("ResourceAsColor")
    private void clearButtons() {
        /*for (int i = 0; i < rootView.getChildCount(); i++) {
            View v=rootView.getChildAt(i);
            if (v instanceof LinearLayout) {
                LinearLayout linear = ((LinearLayout) v);
                for (int j = 0; j < linear.getChildCount(); j++) {
                    if (linear.getChildAt(j) instanceof Button) {
                        Button btn = ((Button) linear.getChildAt(j));
                        btn.setText("");
                    }
                }
            }
        }*/
        for (int i = 0; i < 9; i++) {
            View v = rootView.findViewWithTag(i + "");
            Button button = (Button) v;
            button.setText("");
            button.setBackgroundColor(R.color.white);
        }
    }

    private boolean checkWinner(String Symbol) {
        return checkRows(Symbol) || checkColumns(Symbol) || checkDiagonals(Symbol);
    }

    private boolean checkDiagonals(String Symbol) {
        return borderState[0].equals(Symbol) && borderState[4].equals(Symbol) && borderState[8].equals(Symbol) ||
                borderState[2].equals(Symbol) && borderState[4].equals(Symbol) && borderState[6].equals(Symbol);

    }

    private boolean checkRows(String Symbol) {
        for (int i = 0; i < 9; i += 3)
            if (borderState[i].equals(Symbol) && borderState[i + 1].equals(Symbol) && borderState[i + 2].equals(Symbol))
                return true;
        return false;
    }

    private boolean checkColumns(String Symbol) {
        for (int i = 0; i < 3; i++)
            if (borderState[i].equals(Symbol) && borderState[i + 3].equals(Symbol) && borderState[i + 6].equals(Symbol))
                return true;
        return false;
    }

    private void ChangeBorderState(int index, String Symple) {
        borderState[index] = Symple;
    }

    private int GetIndex(Button clickedButton) {
        return Integer.parseInt(clickedButton.getTag().toString());
    }
}
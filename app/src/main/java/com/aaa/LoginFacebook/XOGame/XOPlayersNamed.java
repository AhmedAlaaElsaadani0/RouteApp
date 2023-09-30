package com.aaa.LoginFacebook.XOGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.aaa.LoginFacebook.R;

public class XOPlayersNamed extends AppCompatActivity {
    EditText Player1NameEditTextView;
    EditText Player2NameEditTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoplayers_named);
        Player1NameEditTextView=findViewById(R.id.input_box_playerOne);
        Player2NameEditTextView=findViewById(R.id.input_box_playerTwo);
        Button btn=findViewById(R.id.StartGame_button);
        btn.setOnClickListener(v ->
        {
            String Player1Name=  Player1NameEditTextView.getText().toString();
            String Player2Name=  Player2NameEditTextView.getText().toString();
            // Handle button click here, navigate to ActivityFacebookPost
            Intent intent = new Intent(XOPlayersNamed.this, XOGame.class);
            intent.putExtra("Player1Name",Player1Name);
            intent.putExtra("Player2Name",Player2Name);
            startActivity(intent);
        });
    }
}
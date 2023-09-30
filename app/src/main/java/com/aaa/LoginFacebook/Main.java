package com.aaa.LoginFacebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.aaa.LoginFacebook.RouteApp.RouteAppMainAc;
import com.aaa.LoginFacebook.XOGame.XOPlayersNamed;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        // ImageView => addClick Event for facebook App
        ImageView FacebookImageView = findViewById(R.id.facebookImage);
        FacebookImageView.setOnClickListener(v -> {
            Intent intent = new Intent(Main.this, LoginActivity.class);
            startActivity(intent);
        });
        // ImageView => addClick Event for Calculator
        ImageView CalculatorImage = findViewById(R.id.CalculatorImage);
        CalculatorImage.setOnClickListener(v -> {
            Intent intent = new Intent(Main.this, com.aaa.LoginFacebook.CalculatorApp.Calculator.class);
            startActivity(intent);
        });

        ImageView xoImage = findViewById(R.id.XoGame);
        xoImage.setOnClickListener(v -> {
            Intent intent = new Intent(Main.this, XOPlayersNamed.class);
            startActivity(intent);
        });

        ImageView routeApp = findViewById(R.id.RouteApp);
        routeApp.setOnClickListener(v -> {
            Intent intent = new Intent(Main.this, com.aaa.LoginFacebook.RouteApp.RouteAppMainAc.class);
            startActivity(intent);
        });

    }

}
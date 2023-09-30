package com.aaa.LoginFacebook.RouteApp;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.aaa.LoginFacebook.R;
import com.aaa.LoginFacebook.RouteApp.FullstackActivity;
import com.aaa.LoginFacebook.XOGame.XOPlayersNamed;

public class RouteAppMainAc extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_app_main);
        ImageView fullstackImage = findViewById(R.id.fullStack);
        fullstackImage.setOnClickListener(v -> {
        Intent intentFullstack=new Intent(RouteAppMainAc.this, FullstackActivity.class);
            startActivity(intentFullstack);
        });

        ImageView xoImage = findViewById(R.id.android);
        xoImage.setOnClickListener(v -> {
            Intent intent = new Intent(RouteAppMainAc.this, AndroidActivity.class);
            startActivity(intent);
        });

        ImageView routeApp = findViewById(R.id.ios);
        routeApp.setOnClickListener(v -> {
            Intent intent = new Intent(RouteAppMainAc.this, com.aaa.LoginFacebook.RouteApp.IOSActivity.class);
            startActivity(intent);
        });
    }
}
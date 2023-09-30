package com.aaa.LoginFacebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button btnLoginFacebook = findViewById(R.id.login_button);
        btnLoginFacebook.setOnClickListener(v -> {
            // Handle button click here, navigate to ActivityFacebookPost
            Intent intent = new Intent(LoginActivity.this, FacebookPost.class);
            startActivity(intent);
        });
    }
}

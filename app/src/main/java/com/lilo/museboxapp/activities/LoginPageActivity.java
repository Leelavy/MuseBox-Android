package com.lilo.museboxapp.activities;
import com.lilo.museboxapp.R;
import com.lilo.museboxapp.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginPageActivity extends AppCompatActivity {

    ImageView backgroundImageView;
    EditText emailInput;
    EditText passwordInput;
    Button loginBtn;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        this.setTitle("Login");

        backgroundImageView = findViewById(R.id.login_activity_background_image_view);
        emailInput = findViewById(R.id.login_activity_email_edit_text);
        passwordInput = findViewById(R.id.login_activity_password_edit_text);

        loginBtn = findViewById(R.id.login_activity_login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "Attempt to login");
            }
        });

        registerBtn = findViewById(R.id.login_activity_register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRegisterPage();
            }
        });
        Utils.animateBackground(backgroundImageView);

    }

    private void toRegisterPage(){
        Intent intent = new Intent(this, RegisterPageActivity.class);
        startActivity(intent);
    }
}
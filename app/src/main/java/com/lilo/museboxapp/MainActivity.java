package com.lilo.museboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.lilo.museboxapp.activities.LoginPageActivity;

public class MainActivity extends AppCompatActivity {

    ImageView backgroundImageView;
    Button exploreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting background, animation and button to login
        backgroundImageView = findViewById(R.id.main_background_image_view);

        exploreBtn = findViewById(R.id.main_explore_button);
        Utils.animateBackground(backgroundImageView);

        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLoginPage();
                MainActivity.this.finish();
            }
        });
    }

    private void toLoginPage(){
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }

}
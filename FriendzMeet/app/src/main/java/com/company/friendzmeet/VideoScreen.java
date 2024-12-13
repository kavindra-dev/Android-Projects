package com.company.friendzmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VideoScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.home:
                            startActivity(new Intent(VideoScreen.this,HomeScreen.class));
                            finish();
                            return true;
                        case R.id.search:
                            startActivity(new Intent(VideoScreen.this,SearchScreen.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                        case R.id.video:
                            startActivity(new Intent(VideoScreen.this,VideoScreen.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                        case R.id.noti:
                            startActivity(new Intent(VideoScreen.this,Notification.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;

                        case R.id.menuu:
                            startActivity(new Intent(VideoScreen.this,MenuOption.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                    }
                    return false;

                });
    }
}
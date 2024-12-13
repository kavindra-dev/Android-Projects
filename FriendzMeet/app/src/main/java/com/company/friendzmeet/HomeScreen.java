package com.company.friendzmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends AppCompatActivity {
    ImageButton cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        cam = findViewById(R.id.camera);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.home:
                            startActivity(new Intent(HomeScreen.this,HomeScreen.class));
                            finish();
                            return true;
                        case R.id.search:
                            startActivity(new Intent(HomeScreen.this,SearchScreen.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                        case R.id.video:
                            startActivity(new Intent(HomeScreen.this,VideoScreen.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                        case R.id.noti:
                            startActivity(new Intent(HomeScreen.this,Notification.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;

                        case R.id.menuu:
                            startActivity(new Intent(HomeScreen.this,MenuOption.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                    }
                    return false;

                });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,Camera_activity.class);
                startActivity(intent);
            }
        });
    }
}
package com.company.friendzmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.home:
                            startActivity(new Intent(Notification.this,HomeScreen.class));
                            finish();
                            return true;
                        case R.id.search:
                            startActivity(new Intent(Notification.this,SearchScreen.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                        case R.id.video:
                            startActivity(new Intent(Notification.this,VideoScreen.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                        case R.id.noti:
                            startActivity(new Intent(Notification.this,Notification.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;

                        case R.id.menuu:
                            startActivity(new Intent(Notification.this,MenuOption.class));
                            overridePendingTransition(0,0);
                            finish();
                            return true;
                    }
                    return false;

                });

    }
}
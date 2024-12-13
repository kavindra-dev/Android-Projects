package com.company.friendzmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

 ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img_logo =findViewById(R.id.imageView);

        AnimatorSet animatorSet = new AnimatorSet();

        ValueAnimator logoAnimator = ValueAnimator.ofFloat(1, 1.2f);
        logoAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                img_logo.setScaleX(value);
                img_logo.setScaleY(value);

            }
        });

        ValueAnimator storeAnimator = ValueAnimator.ofFloat(1, 1.1f);
        storeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                img_logo.setScaleX(value);
                img_logo.setScaleY(value);

            }
        });

        animatorSet.play(logoAnimator).with(storeAnimator);
        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent =  new Intent(MainActivity.this, Login.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        },3000);
    }
}
package com.dzone.placement_for_engineers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = (TextView)findViewById(R.id.slogan);
        iv = (ImageView)findViewById(R.id.logo);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.transitions);
        tv.startAnimation(anim);
        iv.startAnimation(anim);
        final Intent i = new Intent(this, WelcomeActivity.class);
        Thread t = new Thread(){
            public void run()
            {
                try {
                    sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        t.start();


    }
}

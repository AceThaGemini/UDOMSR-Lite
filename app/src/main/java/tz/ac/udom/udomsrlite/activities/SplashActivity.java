package tz.ac.udom.udomsrlite.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tz.ac.udom.udomsrlite.R;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // do magic
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                // clear top
                finish();
            }
        }, 2000);

    }
}

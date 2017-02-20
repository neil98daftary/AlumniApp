package com.example.tejas.alumniapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {


    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Intent i, j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sp = getSharedPreferences("log_data", Context.MODE_PRIVATE);
        //editor = sp.edit();




        i =new Intent(this,Login.class);
        j =new Intent(this, HomeScreen.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if (sp.getInt("log", 9)==1)
                    {
                        startActivity(j);
                    }
                    else
                    {
                        startActivity(i);
                    }
                }

            }
        }).start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}


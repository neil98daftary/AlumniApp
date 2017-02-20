package com.example.tejas.alumniapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void final2(View v)
    {
        String url = "https://docs.google.com/forms/d/1wqpJ9fhxHqpOglQq2HU4A3VcGZxCYulk3v2vY1nUQc8/edit";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}

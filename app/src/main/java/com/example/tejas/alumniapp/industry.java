package com.example.tejas.alumniapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class industry extends AppCompatActivity {

    ImageView downloadedImg;





    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                InputStream inputstream = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(inputstream);

                return myBitmap;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry);
        downloadedImg = (ImageView)findViewById(R.id.imageView);



        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;
        try {
            myImage=task.execute("http://comp.spit.ac.in/files/2011/11/drk1.jpg").get();

            downloadedImg.setImageBitmap(myImage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.test;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    Boolean running=false;
    int[] imagesArray = new int[]{R.drawable.background, R.drawable.riverside, R.drawable.screenlock,R.drawable.sunset};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0, 30);
            running = false;
        }

    }

    class MyTimer extends TimerTask {
        public void run() {
            try
            {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random rand=new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), imagesArray[rand.nextInt(4)]));
            } catch (Exception e)
            {

            }
        }
    }
}

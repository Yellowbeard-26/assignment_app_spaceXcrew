package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ImageViewer extends AppCompatActivity {
    String imageurl;
    Intent intent;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);


        intent= getIntent();
        iv=findViewById(R.id.imageView2);
        LoadImage(iv);
    }
    public void LoadImage(View view)
    {
        imageurl = intent.getStringExtra("url");
        try {
            Glide.with(this).load(imageurl).into(iv);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
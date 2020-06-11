package com.example.cooking_book;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoadImage extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_image);

        imageView = findViewById(R.id.loadimg);

        Intent intent = getIntent();
        int imageID = intent.getIntExtra("imageID", 0);
        imageView.setImageResource(imageID);

    }
}
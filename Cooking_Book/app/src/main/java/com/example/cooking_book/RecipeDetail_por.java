package com.example.cooking_book;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetail_por extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_por);

        Intent intent = getIntent();
        Food food1 = (Food) intent.getSerializableExtra("thongtin");
        RecipeDetail rcpd1 = (RecipeDetail) getSupportFragmentManager().findFragmentById(R.id.fragment_detail_por);
        rcpd1.setdetail(food1);
    }
}

package com.example.cooking_book;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fooddata {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void sendfood(Food food){
        RecipeDetail rcpd = (RecipeDetail) getSupportFragmentManager().findFragmentById(R.id.fragment_detail);

        if(rcpd != null && rcpd.isInLayout()){
            rcpd.setdetail(food);
        }else {
            Intent intent = new Intent(MainActivity.this , RecipeDetail_por.class);
            intent.putExtra("thongtin", food);
            startActivity(intent);
        }


    }

}

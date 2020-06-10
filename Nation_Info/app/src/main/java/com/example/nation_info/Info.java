package com.example.nation_info;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Info extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nation_info);
        Intent intent = getIntent();
        Nation n = (Nation) intent.getSerializableExtra("thongtin");


        TextView name, population, area ;
        ImageView flag;
        name = findViewById(R.id.nname);
        population = findViewById(R.id.npopulation);
        area = findViewById(R.id.narea);

        name.setText("Tên nước: " + n.getName());
        population.setText("Dân số: " + n.getPopulation());
        area.setText("Diện tích: "+ n.getArea() + " km²");

        flag = findViewById(R.id.nflag);
        String url = "https://www.geonames.org/flags/x/"+n.getNameid().toLowerCase()+".gif";
        Picasso.get().load(url).into(flag);
    }


}

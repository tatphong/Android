package com.example.cooking_book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecipeDetail extends Fragment {

    TextView txtname, txtintro, txtingre;
    ImageView txtimage;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.detail, container, false);
        Anhxa();
        return view;
    }

    public void setdetail(Food food){
        txtname.setText(food.getName().toString());
        txtintro.setText(food.getIntro().toString());
        txtingre.setText(food.getIngre().toString());
        String img = food.getImage();
        txtimage.setImageResource(getResources().getIdentifier(img,"drawable", "com.example.cooking_book"));

    }


    private void Anhxa(){
        txtname = (TextView) view.findViewById(R.id.nameV);
        txtintro = (TextView) view.findViewById(R.id.introV);
        txtingre = (TextView) view.findViewById(R.id.ingreV);
        txtimage = (ImageView) view.findViewById(R.id.imageV);
    }

}

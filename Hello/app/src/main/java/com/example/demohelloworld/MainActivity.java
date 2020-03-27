package com.example.demohelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String s="hello, im phong";
        TextView txt = findViewById(R.id.txthello);
        txt.setText(txt.getText().toString() + s);
    }
}

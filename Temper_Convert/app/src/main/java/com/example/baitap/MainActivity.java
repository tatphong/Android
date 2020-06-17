package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView rs;
    private TextView his;
    private double numbRound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rs = findViewById(R.id.rszone);
        his = findViewById(R.id.his);
        final Button Cbtn = findViewById(R.id.convertB);

        Cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup RBG = findViewById(R.id.RG);
                int tem = RBG.getCheckedRadioButtonId();
                RadioButton RD = findViewById(tem);
                String type = RD.getText().toString();

                Toast.makeText(MainActivity.this, type, Toast.LENGTH_SHORT).show();
                //his.setText(RD.getText().toString());


                EditText ip = findViewById(R.id.ipzone);
                if (ip.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter number", Toast.LENGTH_SHORT).show();
                    return;
                }

                String CtoF = "celsius_to_fahrenheit";
                float ipnum = Float.parseFloat(ip.getText().toString());
                double cal;
                if (type.equals(CtoF))
                {
                    cal = (ipnum * 9.0 / 5) + 32.0;
                }
                else
                {
                    cal = (ipnum - 32.0) * (5.0 / 9);
                }

                numbRound = Math.round(cal * 10) / 10.0;
                rs.setText(String.valueOf(numbRound), TextView.BufferType.NORMAL);
                String addhis = type + ":" + ipnum + "-->" + numbRound + "\n";
                his.setText(addhis + his.getText().toString());
            }
        });

        if(savedInstanceState != null){
            //Get result from savedInstanceState
            numbRound = savedInstanceState.getDouble("number");
            //Set result on TextView result
            rs.setText(String.valueOf(numbRound), TextView.BufferType.NORMAL);

            //Get history from savedInstanceState
            CharSequence cs = savedInstanceState.getCharSequence("texthistory");
            //Set history on TextView history
            his.setText(cs.toString());
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("number",numbRound);
        outState.putCharSequence("texthistory", his.getText());
    }

}

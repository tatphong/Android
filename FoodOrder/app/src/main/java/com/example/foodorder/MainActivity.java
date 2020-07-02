package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_send_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup;
                int selectedId;

//                get size
                radioGroup = (RadioGroup) findViewById(R.id.groupSize);
                selectedId = radioGroup.getCheckedRadioButtonId();
                String str_size;
                if (selectedId == R.id.radioMedium)
                    str_size = "medium";
                else
                    str_size = "large";

//                get tortilla
                radioGroup = (RadioGroup) findViewById(R.id.groupTortilla);
                selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton tortilla = findViewById(selectedId);
                String str_tortilla;
                if (selectedId == R.id.radioCorn)
                    str_tortilla = "corn";
                else
                    str_tortilla = "flour";

                //*************Filling group*************
                CheckBox beef = findViewById(R.id.checkBeef);
                CheckBox chicken = findViewById(R.id.checkChicken);
                CheckBox fish = findViewById(R.id.checkFish);
                CheckBox cheese = findViewById(R.id.checkCheese);
                CheckBox seaFood = findViewById(R.id.checkSeaFood);
                CheckBox rice = findViewById(R.id.checkRice);
                CheckBox beans = findViewById(R.id.checkBeans);
                CheckBox pico = findViewById(R.id.checkPico);
                CheckBox guacamole = findViewById(R.id.checkGuacamole);
                CheckBox LBT = findViewById(R.id.checkLBT);
                String str_filling = "";

                Queue<String> q = new LinkedList<>();
                if (beef.isChecked()) q.add("beef");
                if (chicken.isChecked()) q.add("chicken");
                if (fish.isChecked()) q.add("white fish");
                if (cheese.isChecked()) q.add("cheese");
                if (seaFood.isChecked()) q.add("sea food");
                if (rice.isChecked()) q.add("rice");
                if (beans.isChecked()) q.add("beans");
                if (pico.isChecked()) q.add("pico de Gallo");
                if (guacamole.isChecked()) q.add("guacamole");
                if (LBT.isChecked()) q.add("LBT");

                while (!q.isEmpty()) {
                    if (str_filling == "")
                        str_filling += q.element();
                    else str_filling += ", " + q.element();
                    q.remove();
                }

                //****************Beverage group***********
                CheckBox soda = findViewById(R.id.checkSoda);
                CheckBox cerveza = findViewById(R.id.checkCerveza);
                CheckBox margarita = findViewById(R.id.checkMargarita);
                CheckBox tequila = findViewById(R.id.checkTequila);
                String str_beverage = "";
                if (soda.isChecked()) q.add("soda");
                if (cerveza.isChecked()) q.add("cerveza");
                if (margarita.isChecked()) q.add("margarita");
                if (tequila.isChecked()) q.add("tequila");

                while (!q.isEmpty()) {
                    if (str_beverage == "")
                        str_beverage += q.element();
                    else str_beverage += ", " + q.element();
                    q.remove();
                }

                String filling="";
                if (str_filling != "") filling = " and filling with " + str_filling;
                String beverage="";
                if (str_beverage != "") beverage = ". Beverage: " + str_beverage;

                String msg = "I want a " + str_size + " taco make with " + str_tortilla + filling + beverage;
//                System.out.print(msg);
//                System.out.print("end");
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("0375327691", null, msg, null, null);
                Toast.makeText(MainActivity.this, "Your order is sent.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}

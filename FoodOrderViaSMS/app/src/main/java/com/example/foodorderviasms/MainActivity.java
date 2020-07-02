package com.example.foodorderviasms;

import android.Manifest;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.button_send_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);*/
                //***************Radio Group***************
                RadioGroup radioGroup;
                int selectedId;
                int siz = R.id.groupSize;
                int be = R.id.checkBeans;
                System.out.println(be);
                System.out.println(siz);
//                get size
                radioGroup = (RadioGroup) findViewById(R.id.groupSize);
                selectedId = radioGroup.getCheckedRadioButtonId();
                System.out.println(selectedId);
                RadioButton size = findViewById(selectedId);
//                get tortilla
                radioGroup = (RadioGroup) view.findViewById(R.id.groupTortilla);
                selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton tortilla = view.findViewById(selectedId);


                //*************Filling group*************
                int beef = R.id.checkBeef;
                int chicken = R.id.checkChicken;
                int fish = R.id.checkFish;
                int cheese = R.id.checkCheese;
                int seaFood = R.id.checkSeaFood;
                int rice = R.id.checkRice;
                int beans = R.id.checkBeans;
                int pico = R.id.checkPico;
                int guacamole = R.id.checkGuacamole;
                int LBT = R.id.checkLBT;
                String str_filling = "";

                Queue<String> q = new LinkedList<>();
                if (beef == 1) q.add("beef");
                if (chicken == 1) q.add("chicken");
                if (fish == 1) q.add("white fish");
                if (cheese == 1) q.add("cheese");
                if (seaFood == 1) q.add("sea food");
                if (rice == 1) q.add("rice");
                if (beans == 1) q.add("beans");
                if (pico == 1) q.add("pico de Gallo");
                if (guacamole == 1) q.add("guacamole");
                if (LBT == 1) q.add("LBT");

                while (!q.isEmpty()) {
                    if (str_filling == "")
                        str_filling += q.element();
                    else str_filling += ", " + q.element();
                    q.remove();
                }

                //****************Beverage group***********
                int soda = R.id.checkSoda;
                int cerveza = R.id.checkCerveza;
                int margarita = R.id.checkMargarita;
                int tequila = R.id.checkTequila;
                String str_beverage = "";
                if (soda == 1) q.add("soda");
                if (cerveza == 1) q.add("cerveza");
                if (margarita == 1) q.add("margarita");
                if (tequila == 1) q.add("tequila");

                while (!q.isEmpty()) {
                    if (str_beverage == "")
                        str_beverage += q.element();
                    else str_beverage += ", " + q.element();
                    q.remove();
                }

                String msg = "I want a " + size.getText() + " taco make with " + tortilla.getText() + " and filling with" + str_filling + ". Beverage: " + str_beverage;
                System.out.print(msg);
                System.out.print("end");
//                SmsManager smsManager = SmsManager.getDefault();
//                smsManager.sendTextMessage("0375327691", null, msg, null, null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

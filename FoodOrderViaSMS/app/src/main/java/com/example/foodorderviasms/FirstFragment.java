package com.example.foodorderviasms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.telephony.SmsManager;
import android.widget.RadioButton;

import java.util.LinkedList;
import java.util.Queue;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_send_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);*/
                //***************Radio Group***************
                int size = R.id.radioMedium;
                int tortilla = R.id.radioCorn;
                String str_size;
                String str_tortilla;
                if ( size==0 )
                    str_size="large";
                else str_size="medium";
                if ( tortilla==1 )
                    str_tortilla="corn";
                else str_tortilla="flour";

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
                String str_filling="";

                Queue<String> q=new LinkedList<>();
                if (beef==1) q.add("beef");
                if (chicken==1) q.add("chicken");
                if (fish==1) q.add("white fish");
                if (cheese==1) q.add("cheese");
                if (seaFood==1) q.add("sea food");
                if (rice==1) q.add("rice");
                if (beans==1) q.add("beans");
                if (pico==1) q.add("pico de Gallo");
                if (guacamole==1) q.add("guacamole");
                if (LBT==1) q.add("LBT");

                while (!q.isEmpty()){
                    if (str_filling=="")
                        str_filling+=q.element();
                    else str_filling+=", "+q.element();
                    q.remove();
                }

                //****************Beverage group***********
                int soda = R.id.checkSoda;
                int cerveza = R.id.checkCerveza;
                int margarita = R.id.checkMargarita;
                int tequila = R.id.checkTequila;
                String str_beverage="";
                if (soda==1) q.add("soda");
                if (cerveza==1) q.add("cerveza");
                if (margarita==1) q.add("margarita");
                if (tequila==1) q.add("tequila");

                while (!q.isEmpty()){
                    if (str_beverage=="")
                        str_beverage+=q.element();
                    else str_beverage+=", "+q.element();
                    q.remove();
                }

                String msg="I want a "+str_size+" taco make with "+str_tortilla+" and filling with"+str_filling+". Beverage: "+str_beverage;
                System.out.print(msg);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("5556", null, msg, null, null);
            }
        });
    }
}

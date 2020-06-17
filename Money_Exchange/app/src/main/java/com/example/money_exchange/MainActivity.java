package com.example.money_exchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    ArrayList<Currency> money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money = new ArrayList<>();
     //   ArrayAdapter ar = new  ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, test);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FetchData fd = new FetchData();
                fd.execute("https://usd.fxexchangerate.com/rss.xml","https://vnd.fxexchangerate.com/rss.xml");
            }
        });

        //
        Button exchange = findViewById(R.id.button);
        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner mfrom = findViewById(R.id.mfrom);
                Spinner mto = findViewById(R.id.mto);
                Integer from_position = mfrom.getSelectedItemPosition();
                Integer to_position = mto.getSelectedItemPosition();

                //get currency
                Currency cur1 = money.get(from_position);
                Currency cur2 = money.get(to_position);

                //solve
                EditText input;
                input = findViewById(R.id.input);
                TextView output = findViewById(R.id.output);
                System.out.println(input.getText());
                System.out.println(input.toString());
                double res = 0;
                res = Double.parseDouble(String.valueOf(input.getText())) * (cur2.getPrice()/cur1.getPrice());
                output.setText(String.valueOf(Math.round(res*100)*1.0/100)+" "+cur2.getCode());
            }
        });
    }

    class FetchData extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
         //   Toast.makeText(MainActivity.this, s,Toast.LENGTH_LONG).show();
            xuli(s);
            update();
            super.onPostExecute(s);
        }

        private String docNoiDung_Tu_URL(String theUrl){
            StringBuilder content = new StringBuilder();
            try    {
                URL url = new URL(theUrl);
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line + "\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)    {
                e.printStackTrace();
            }

            return content.toString();
        }
        public void xuli(String s)
        {
            XMLDOMParser pa = new XMLDOMParser();
            Document doc = pa.getDocument(s);
            NodeList nodelist = doc.getElementsByTagName("item");
            for(int i=0;i<nodelist.getLength();i++)
            {
                String name, code;
                double price;
                Element ele = (Element) nodelist.item(i);
                String title = pa.getValue(ele,"title");
                String des = pa.getValue(ele,"description");
                name = title.substring(title.indexOf("/")+1);
                code = name.substring(name.indexOf("(")+1,name.lastIndexOf(")"));
                String tmp = des.substring(des.indexOf("=")+2);
                String tmp2 = tmp.substring(0,tmp.indexOf(" "));
                price = Double.parseDouble(tmp2);
                money.add(new Currency(name,code,price));
                //Toast.makeText(MainActivity.this, name + code + price,Toast.LENGTH_SHORT).show();
            }


        }
    }

    public void update()
    {
        spinner1 = findViewById(R.id.mfrom);
        spinner2 = findViewById(R.id.mto);
           Toast.makeText(MainActivity.this, String.valueOf(money.size()),Toast.LENGTH_LONG).show();
        Cadapter ca1 = new Cadapter(MainActivity.this,money);
        spinner1.setAdapter(ca1);
        spinner2.setAdapter(ca1);
    }

}

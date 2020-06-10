package com.example.nation_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ListView nlistView;
    public ArrayList<Nation> nation;
    Nadapter na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nation = new ArrayList<>();
        FetchData fetchData = new FetchData();
        fetchData.execute();
        updatelist(nation);
    }


    public class FetchData extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String data = "";
            URL url = null;
            try {
                url = new URL("http://api.geonames.org/countryInfoJSON?formatted=true&username=man18&style=full");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data += line;
                }

                if (data.isEmpty())
                    return null;

                JSONObject jsonObject = new JSONObject(data);
                JSONArray geonamesArray = jsonObject.getJSONArray("geonames");
                for (int i = 0; i < geonamesArray.length(); i++) {
                    JSONObject geonamesObject = (JSONObject) geonamesArray.getJSONObject(i);
                    nation.add(new Nation(geonamesObject.getString("countryName"),geonamesObject.getString("population"),geonamesObject.getString("areaInSqKm"),geonamesObject.getString("countryCode")));

                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            updatelist(nation);
        }

    }

    public void updatelist(ArrayList<Nation> nation1 )
    {
        nlistView = findViewById(R.id.listview);
        na = new Nadapter(MainActivity.this , nation1);
        nlistView.setAdapter(na);
    }

}

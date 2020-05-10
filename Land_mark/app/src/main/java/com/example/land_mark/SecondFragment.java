package com.example.land_mark;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SecondFragment extends Fragment {

    String item_name = "null", item_url = "http://www.facebook.com";
    TextView text_detail;
    private final String TAG = "MapLocation";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View second_view = inflater.inflate(R.layout.fragment_second, container, false);
        text_detail = second_view.findViewById(R.id.textDetail);

        Bundle bundle = getArguments();
        if (bundle != null) {
            item_name = bundle.getString("item_name", "");
            item_url = bundle.getString("item_url", "http://www.google.com");
        }

        text_detail.setText(item_name.split("\\. ")[1]);
        Log.i(TAG, item_name.split("\\. ")[1]);

        //go to gg map
        Button map = second_view.findViewById(R.id.buttonMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    // Process text for network transmission
                    String address = text_detail.getText().toString();
                    address = address.replace(' ', '+');

                    // Create Intent object for starting Google Maps application
                    Intent geoIntent = new Intent(
                            android.content.Intent.ACTION_VIEW, Uri
                            .parse("geo:0,0?q=" + address));

                    // Use the Intent to start Google Maps application using Activity.startActivity()
                    startActivity(geoIntent);

                } catch (Exception e) {
                    // Log any error messages to LogCat using Log.e()
                    Log.e(TAG, e.toString());
                }
            }
        });

        //go to web page
        Button info = second_view.findViewById(R.id.buttonInfo);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse(item_url.toString());
                Intent launchBrowser = new Intent(android.content.Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        return second_view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}

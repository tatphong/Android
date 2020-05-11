package com.example.land_mark;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    ListView lv;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        //create list item with adapter

        View rootView =inflater.inflate(R.layout.fragment_first, container, false);
        lv = (ListView)rootView.findViewById(R.id.list);

        //init list data
        final ArrayList<LandMark> landMark = new ArrayList<LandMark>();
        landMark.add(new LandMark("Cleveland Tower City", "https://en.wikipedia.org/wiki/Tower_City_Center"));
        landMark.add(new LandMark("Cleveland Browns Football Field", "https://firstenergystadium.com/"));
        landMark.add(new LandMark("Cleveland State University", "https://www.csuohio.edu/"));
        landMark.add(new LandMark("Cleveland Playhouse Square", "http://www.playhousesquare.org/"));
        landMark.add(new LandMark("Cleveland Art Museum", "https://www.clevelandart.org/"));

        String [] landmarks = {
                "1. Cleveland Tower City",
                "2. Cleveland Browns Football Field",
                "3. Cleveland State University",
                "4. Cleveland Playhouse Square",
                "5. Cleveland Art Museum"
        };
        //set adapter to listView
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, landmarks);
        lv.setAdapter(arrayAdapter);

        //set list item onclick listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get data from selected item
                String item_list = (String) lv.getItemAtPosition(position);

                SecondFragment secondFragment = new SecondFragment();
                Bundle bundle = new Bundle();
                //send it to fragment 2
                bundle.putString("item_name", item_list);
                bundle.putString("item_url", landMark.get(position).get_url());
                secondFragment.setArguments(bundle);

                //navigate to fragment:2
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });
        return rootView;
    }

//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
//    }
}

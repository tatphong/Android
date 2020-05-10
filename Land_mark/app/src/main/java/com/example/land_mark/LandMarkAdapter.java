package com.example.land_mark;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LandMarkAdapter extends ArrayAdapter<LandMark>{
    private Activity mContext;
    private ArrayList<LandMark> landMarkList = new ArrayList<>();

    public LandMarkAdapter(@NonNull Activity context, ArrayList<LandMark> list) {
        super(context, 0 , list);
        mContext = context;
        landMarkList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RecyclerView.ViewHolder holder;
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);


        }
        LandMark currentLandMark = landMarkList.get(position);
        Log.i("current position", String.valueOf(landMarkList.get(position)));
        TextView name = (TextView) listItem.findViewById(R.id.textView);
        name.setText(currentLandMark.get_name());
        Log.i("current name",currentLandMark.get_name());
        return listItem;
    }
}

package com.example.land_mark;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LandMarkAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<LandMark> landMarkList = new ArrayList<>();

    public LandMarkAdapter(@NonNull Context context, ArrayList<LandMark> list) {
        this.context = context;
        landMarkList = list;
    }

//    private class ViewHolder{
//        TextView textView;
//    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
//            viewHolder = new ViewHolder();
//            viewHolder.textView = convertView.findViewById(R.id.textView);
//            convertView.setTag(viewHolder);
//        }else{
//            viewHolder = (ViewHolder) convertView.getTag();

            TextView textView = convertView.findViewById(R.id.textView);
            textView.setText(position + ". " +landMarkList.get(position).get_name());
        }
//        viewHolder.textView.setText(position + ". " +landMarkList.get(position).get_name());
        return convertView;
    }
}

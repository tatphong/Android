package com.example.money_exchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Cadapter extends BaseAdapter {

    private Context con;
    private int layout;
    private ArrayList<Currency> nlist;

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return nlist.size();
    }

    public Cadapter(Context con, ArrayList<Currency> nlistt) {
        this.layout = R.layout.item;
        this.con = con;
        this.nlist = nlistt;

    }

    private class ViewHolder {
        TextView text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, null);

            vh.text = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        final Currency c1 = nlist.get(position);
        vh.text.setText(c1.getName());
        return convertView;
    }

}

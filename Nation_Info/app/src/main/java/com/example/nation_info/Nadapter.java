package com.example.nation_info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class Nadapter extends ArrayAdapter<Nation> {

    private Context con;
    private ArrayList<Nation> nlist;


    public Nadapter(Context con, ArrayList<Nation> nlistt) {
        super(con, R.layout.nlist_item, nlistt);
        this.con = con;
        this.nlist = nlistt;

    }
    private class ViewHolder{
        TextView text;
        Button button;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nlist_item, null);
            vh = new ViewHolder();
            vh.text = (TextView) convertView.findViewById(R.id.nationView);
            vh.button = (Button) convertView.findViewById(R.id.click);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        final Nation n1 = nlist.get(position);
        vh.text.setText(n1.getName());
        vh.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con, Info.class);
                intent.putExtra("thongtin", n1);
                con.startActivity(intent);
            }
        });
        return convertView;
    }
}

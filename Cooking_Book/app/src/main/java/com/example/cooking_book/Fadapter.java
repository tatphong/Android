package com.example.cooking_book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class Fadapter extends BaseAdapter  {
    private Context con;
    private int layout;
    private List<Food> foodlist;


    public Fadapter(Context con, int layout, List<Food> foodlist) {
        this.con = con;
        this.layout = layout;
        this.foodlist = foodlist;
    }
    private class ViewHolder{
        TextView txtname;
        ImageView txtimg;
    }


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
        return foodlist.size();
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null ){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtname = (TextView) view.findViewById(R.id.LnameV);
            holder.txtimg = (ImageView) view.findViewById(R.id.LimageV);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Food f1 = foodlist.get(position);
        holder.txtname.setText(f1.getName());
        final String i = f1.getImage();
        holder.txtimg.setImageResource(con.getResources().getIdentifier(i,"drawable", "com.example.cooking_book"));

        holder.txtimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(con, LoadImage.class);
                int ii = con.getResources().getIdentifier(i,"drawable", "com.example.cooking_book");
                intent.putExtra("imageID", ii);
                con.startActivity(intent);
            }
        });



        return view;
    }
}

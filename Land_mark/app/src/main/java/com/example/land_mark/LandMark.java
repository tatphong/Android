package com.example.land_mark;

import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

public class LandMark {
//    private static final AtomicInteger count = new AtomicInteger(0);
//    int id;
    String name;
    String url;

    public void LandMark(){
    }
    public void add_data(String name, String url){
//        this.id = count.incrementAndGet(); // auto increase and get
        this.name = name;
        this.url = url;
    }
    public void print_data(){
//        Log.i("id; name; url",id+"; "+name+"; "+url);
    }
    public String get_name(){
        return this.name;
    }
    public String get_url(){
        return this.url;
    }
}

package com.example.nation_info;

import java.io.Serializable;

public class Nation implements Serializable {

    private String name;
    private String population;
    private String area;
    private String nameid;

    public Nation(String name, String population, String area, String nameid) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.nameid = nameid;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public String getNameid() {
        return nameid;
    }
}

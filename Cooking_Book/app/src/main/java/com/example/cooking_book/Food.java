package com.example.cooking_book;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private String intro;
    private String ingre;
    private String image;

    public Food(String name, String intro, String ingre, String image) {
        this.name = name;
        this.intro = intro;
        this.ingre = ingre;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIngre() {
        return ingre;
    }

    public void setIngre(String ingre) {
        this.ingre = ingre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

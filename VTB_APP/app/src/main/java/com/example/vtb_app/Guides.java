package com.example.vtb_app;

public class Guides {
    private String name;
    private String difficulty;
    private String imgURL;


    public Guides(String name, String difficulty, String imgURL) {
        this.difficulty = difficulty;
        this.name = name;
        this.imgURL = imgURL;

    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}

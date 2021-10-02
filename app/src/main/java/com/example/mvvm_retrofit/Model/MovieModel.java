package com.example.mvvm_retrofit.Model;

public class MovieModel {


    private String name, language;
    private Image image;

    public MovieModel(Image image, String name, String language) {
        this.image = image;
        this.name = name;
        this.language = language;
    }

    public Image getImage() { return image; }

    public String getName() { return name; }

    public String getLanguage() { return language; }

}

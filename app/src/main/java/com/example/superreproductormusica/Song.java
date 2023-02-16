package com.example.superreproductormusica;

public class Song {
    private int id;
    private String name, author, route, route_img;


    public Song(int id, String name, String author, String route, String route_img) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.route = route;
        this.route_img = route_img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getRoute() {
        return route;
    }

    public String getRoute_img() {
        return getRoute_img();
    }

    public void setRoute_img(String route_img) {
        this.route_img = route_img;
    }

}

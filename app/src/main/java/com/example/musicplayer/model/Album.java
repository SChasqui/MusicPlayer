package com.example.musicplayer.model;

import java.io.Serializable;

public class Album implements Serializable {

    private String title;
    private String cover;
    private String cover_big;

    public Album() {
    }

    public Album(String title, String cover) {
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }
}

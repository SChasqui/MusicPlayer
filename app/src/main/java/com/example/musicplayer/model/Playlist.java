package com.example.musicplayer.model;

import java.io.Serializable;

public class Playlist implements Serializable {

    private String title;
    private int nb_tracks;
    private String link;
    private String picture;
    private String picture_big;
    private User user;
    private int fans;
    private String id;
    private DataSongs tracks;
    private String description;

    public Playlist() {
    }

    public Playlist(String title, int nb_tracks, String link, String picture, User user, int fans, String id, DataSongs tracks, String description) {
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.link = link;
        this.picture = picture;
        this.user = user;
        this.fans = fans;
        this.id = id;
        this.tracks = tracks;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataSongs getTracks() {
        return tracks;
    }

    public void setTracks(DataSongs tracks) {
        this.tracks = tracks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }
}

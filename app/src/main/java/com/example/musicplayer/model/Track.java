package com.example.musicplayer.model;

import java.io.Serializable;

public class Track implements Serializable {

    private String title,link;
    private Artist artist;
    private Album album;
    private int duration;
    private String picture;
    private String release_date;
    private String id;
    private String preview;



    public Track() {
    }

    public Track(String title, String link, Artist artist, Album album, int duration, String picture, String release_date) {
        this.title = title;
        this.link = link;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.picture = picture;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}

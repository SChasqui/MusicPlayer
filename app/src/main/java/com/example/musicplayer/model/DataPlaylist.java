package com.example.musicplayer.model;

public class DataPlaylist {

    private Playlist[] data;

    public DataPlaylist() {
    }

    public DataPlaylist(Playlist[] data) {
        this.data = data;
    }

    public Playlist[] getData() {
        return data;
    }

    public void setData(Playlist[] data) {
        this.data = data;
    }
}

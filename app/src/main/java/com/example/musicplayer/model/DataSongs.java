package com.example.musicplayer.model;

public class DataSongs {

    private Track[] data;

    public DataSongs() {
    }

    public DataSongs(Track[] data) {
        this.data = data;
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }
}

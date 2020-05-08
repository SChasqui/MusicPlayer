package com.example.musicplayer.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicplayer.R;
import com.example.musicplayer.control.TracksController;

public class TracksActivity extends AppCompatActivity {

    private ImageView playListIV;
    private TextView namePlaylistTV;
    private TextView descTV;
    private TextView nb_songsTV;
    private TextView nb_fansTV;
    private RecyclerView tracks_list;
    private TracksController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_bgnd));
        }

        playListIV = findViewById(R.id.playlistIV);
        namePlaylistTV = findViewById(R.id.namePlaylistTV);
        descTV = findViewById(R.id.descTV);
        nb_songsTV = findViewById(R.id.nb_TracksTV);
        nb_fansTV = findViewById(R.id.nb_fansTV);
        tracks_list = findViewById(R.id.tracksList);

        controller = new TracksController(this);

    }

    public ImageView getPlayListIV() {
        return playListIV;
    }

    public void setPlayListIV(ImageView playListIV) {
        this.playListIV = playListIV;
    }

    public TextView getNamePlaylistTV() {
        return namePlaylistTV;
    }

    public void setNamePlaylistTV(TextView namePlaylistTV) {
        this.namePlaylistTV = namePlaylistTV;
    }

    public TextView getDescTV() {
        return descTV;
    }

    public void setDescTV(TextView descTV) {
        this.descTV = descTV;
    }

    public TextView getNb_songsTV() {
        return nb_songsTV;
    }

    public void setNb_songsTV(TextView nb_songsTV) {
        this.nb_songsTV = nb_songsTV;
    }

    public TextView getNb_fansTV() {
        return nb_fansTV;
    }

    public void setNb_fansTV(TextView nb_fansTV) {
        this.nb_fansTV = nb_fansTV;
    }

    public RecyclerView getTracks_list() {
        return tracks_list;
    }

    public void setTracks_list(RecyclerView tracks_list) {
        this.tracks_list = tracks_list;
    }
}

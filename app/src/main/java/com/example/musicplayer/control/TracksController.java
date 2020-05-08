package com.example.musicplayer.control;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.musicplayer.model.Album;
import com.example.musicplayer.model.Artist;
import com.example.musicplayer.model.Playlist;
import com.example.musicplayer.model.Track;
import com.example.musicplayer.util.Constants;
import com.example.musicplayer.util.HTTPSWebUtilDomi;
import com.example.musicplayer.view.SongActivity;
import com.example.musicplayer.view.TracksActivity;
import com.example.musicplayer.view.TracksAdapter;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TracksController implements HTTPSWebUtilDomi.OnResponseListener {


    private TracksActivity activity;
    private ArrayList<Track> tracks;
    private Playlist playlist;
    private HTTPSWebUtilDomi util;
    private TracksAdapter adapter;
    //private TracksAdapter adapter;

    public TracksController(TracksActivity activity) {
        this.activity = activity;
        tracks = new ArrayList<>();
        util = new HTTPSWebUtilDomi();
        util.setListener(this);

        if(activity!=null) receiveDataFromActivity();


        activity.getTracks_list().setLayoutManager(new LinearLayoutManager(activity));
        adapter = new TracksAdapter(tracks);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, SongActivity.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("songData",tracks.get(activity.getTracks_list().getChildAdapterPosition(v)));
                i.putExtra("songData",tracks.get(activity.getTracks_list().getChildAdapterPosition(v)));
                activity.startActivity(i);
/*
                Toast.makeText(activity.getApplicationContext(), "Clicked: "+tracks.get
                        (activity.getTracks_list().getChildAdapterPosition(v)).getTitle(), Toast.LENGTH_LONG).show();
*/

            }
        });

        activity.getTracks_list().setAdapter(adapter);

        loadData();

/*        activity.runOnUiThread(
                ()->{
                    TracksAdapter adapter = new TracksAdapter(tracks);
                    activity.getTracks_list().setAdapter(adapter);
                }
        );*/


    }

    private void receiveDataFromActivity() {
        Bundle extras = activity.getIntent().getExtras();
        playlist = (Playlist) extras.getSerializable("playlistData");


    }

    private void loadData(){

        new Thread(
                ()->{
                    Log.e(">>>Request:","https://api.deezer.com/playlist/"+playlist.getId()+ " UtilState: "+util);
                    util.GETrequest(Constants.PLAYLIST_CALLBACK,"https://api.deezer.com/playlist/"+playlist.getId());

                }
        ).start();
    }

    private void addTrack(Track track){
        tracks.add(track);
    }


    @Override
    public void onResponse(int callbackID, String response) {

        switch (callbackID){
            case Constants.PLAYLIST_CALLBACK:

                Gson gson = new Gson();
                Playlist data = gson.fromJson(response,Playlist.class);

                activity.runOnUiThread(
                        ()->{
                            activity.getNamePlaylistTV().setText(data.getTitle());
                            if(!data.getDescription().equals("") && data.getDescription()!=null){
                                activity.getDescTV().setText(data.getDescription());
                            }else{
                                activity.getDescTV().setText("Sin descripción");
                            }
                            activity.getNb_songsTV().setText("Canciones: "+data.getTracks().getData().length);
                            activity.getNb_fansTV().setText("Fans: "+data.getFans());

                            Glide.with(activity).load(
                                    data.getPicture_big()
                            ).into(activity.getPlayListIV());
                        }
                );

                Log.e(">>>Response:",""+ data.getTracks().getData().length);

                new Thread(
                        ()->{
                            for(int i =0; i<data.getTracks().getData().length;i++){
                                util.GETrequest(Constants.TRACK_CALLBACK,"https://api.deezer.com/track/"+data.getTracks().getData()[i].getId());
                            }
                        }
                ).start();


                break;

            case Constants.TRACK_CALLBACK:
                Gson gson2 = new Gson();
                Track track = gson2.fromJson(response,Track.class);
                addTrack(track);

                activity.runOnUiThread(
                        ()->{
                            activity.getTracks_list().getAdapter().notifyItemChanged(tracks.size());

                        }
                );

/*                activity.runOnUiThread(
                        ()->{
                            //Mejorar este metodo
                            TracksAdapter adapter = new TracksAdapter(tracks);
                            activity.getTracks_list().setAdapter(adapter);

                        }
                );*/


                break;

        }
    }
}

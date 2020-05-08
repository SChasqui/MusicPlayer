package com.example.musicplayer.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.musicplayer.R;
import com.example.musicplayer.model.DataPlaylist;
import com.example.musicplayer.model.Playlist;
import com.example.musicplayer.util.Constants;
import com.example.musicplayer.util.HTTPSWebUtilDomi;
import com.example.musicplayer.view.MainActivity;
import com.example.musicplayer.view.TracksActivity;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener, AdapterView.OnItemClickListener {

    private MainActivity activity;
    private HTTPSWebUtilDomi util;

    public MainController(MainActivity activity) {

        this.activity = activity;
        util = new HTTPSWebUtilDomi();
        util.setListener(this);

        activity.getBuscarIV().setOnClickListener(this);
        activity.getListPlaylists().setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.searchIV:
                activity.getLinearIntro().setVisibility(View.GONE);
                String query = activity.getBuscarET().getText().toString();
                Toast.makeText(activity,query,Toast.LENGTH_SHORT).show();
                new Thread(
                        ()->{

                            util.GETrequest(Constants.SEARCH_CALLBACK,"https://api.deezer.com/search/playlist?q="+query);

                        }
                ).start();

                break;

            case R.id.listPlaylists:

                break;

        }
    }

    @Override
    public void onResponse(int callbackID, String response) {

        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                DataPlaylist dataPlaylist = gson.fromJson(response, DataPlaylist.class);

                activity.runOnUiThread(
                        ()->{

                            for(int i = 0; i< dataPlaylist.getData().length; i++){
                                activity.getAdapter().addPlaylist(dataPlaylist.getData()[i]);
                            }
                        }
                );
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Playlist playlist = (Playlist) activity.getListPlaylists().getItemAtPosition(position);
        Toast.makeText(activity, "Item clicked: "+playlist.getTitle(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(activity, TracksActivity.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable("playlistData",playlist);
        i.putExtra("playlistData",playlist);
        activity.startActivity(i);
        activity.setAdapter(null);
    }
}

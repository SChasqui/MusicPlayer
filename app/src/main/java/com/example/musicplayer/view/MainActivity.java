package com.example.musicplayer.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.musicplayer.R;
import com.example.musicplayer.control.MainController;

public class MainActivity extends AppCompatActivity {

    private EditText searchET;
    private ImageView searchIV;
    private ListView listPlaylists;
    private MainController controller;
    private PlaylistsAdapter adapter;
    private LinearLayout linearIntro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_bgnd));
        }

        searchET = findViewById(R.id.searchET);
        searchIV = findViewById(R.id.searchIV);
        listPlaylists = findViewById(R.id.listPlaylists);
        linearIntro = findViewById(R.id.linearLayoutIntro);

        controller = new MainController(this);

        adapter = new PlaylistsAdapter();
        listPlaylists.setAdapter(adapter);




    }

    public EditText getSearchET() {
        return searchET;
    }

    public void setSearchET(EditText searchET) {
        this.searchET = searchET;
    }

    public ImageView getSearchIV() {
        return searchIV;
    }

    public void setSearchIV(ImageView searchIV) {
        this.searchIV = searchIV;
    }

    public ListView getListPlaylists() {
        return listPlaylists;
    }

    public void setListPlaylists(ListView listPlaylists) {
        this.listPlaylists = listPlaylists;
    }

    public PlaylistsAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(PlaylistsAdapter adapter) {
        this.adapter = adapter;
    }

    public EditText getBuscarET() {
        return searchET;
    }

    public void setBuscarET(EditText buscarET) {
        this.searchET = buscarET;
    }

    public ImageView getBuscarIV() {
        return searchIV;
    }

    public void setBuscarIV(ImageView buscarIV) {
        this.searchIV = buscarIV;
    }

    public MainController getController() {
        return controller;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public LinearLayout getLinearIntro() {
        return linearIntro;
    }

    public void setLinearIntro(LinearLayout linearIntro) {
        this.linearIntro = linearIntro;
    }
}

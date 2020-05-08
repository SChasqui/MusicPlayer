package com.example.musicplayer.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.musicplayer.R;
import com.example.musicplayer.model.Playlist;

import java.util.ArrayList;

public class PlaylistsAdapter extends BaseAdapter {

    private ArrayList<Playlist> playlists;

    public PlaylistsAdapter() {
        this.playlists = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return playlists.size();
    }

    @Override
    public Object getItem(int position) {
        return playlists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Volver a la vista independiente, cuando pongo null en el root (no está attached a ningún root)
        View row = inflater.inflate(R.layout.playlist_item, null,false);

        ImageView imageView = row.findViewById(R.id.trackIV);
        TextView name = row.findViewById(R.id.nameTrackTV);
        TextView creator = row.findViewById(R.id.artistTV);
        TextView nb_songs = row.findViewById(R.id.nb_TracksTV);

        name.setText(playlists.get(position).getTitle());
        creator.setText("Creador: "+playlists.get(position).getUser().getName());
        nb_songs.setText("Songs: "+playlists.get(position).getNb_tracks());

        Glide.with(viewGroup).load(
                playlists.get(position).getPicture()
        ).into(imageView);

        return row;
    }

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);

        notifyDataSetChanged();

    }
}

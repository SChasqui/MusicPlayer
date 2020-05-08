package com.example.musicplayer.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicplayer.R;
import com.example.musicplayer.model.Track;

import java.util.ArrayList;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolderTracks> implements View.OnClickListener {

    private ArrayList<Track> tracks;
    private View.OnClickListener listener;

    public TracksAdapter(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolderTracks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tracks_item,null,false);
        view.setOnClickListener(this);

        return new ViewHolderTracks(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTracks holder, int position) {


        holder.nameTrackTV.setText(tracks.get(position).getTitle());
        holder.artistTV.setText(tracks.get(position).getArtist().getName());
        holder.yearTV.setText(tracks.get(position).getRelease_date());
        Glide.with(holder.itemView).load(

                tracks.get(position).getAlbum().getCover()
        ).into(holder.trackIV);

    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }


    public class ViewHolderTracks extends RecyclerView.ViewHolder {

        ImageView trackIV;
        TextView nameTrackTV, artistTV, yearTV;


        public ViewHolderTracks(@NonNull View itemView) {
            super(itemView);
            trackIV = itemView.findViewById(R.id.trackIV);
            nameTrackTV = itemView.findViewById(R.id.nameTrackTV);
            artistTV = itemView.findViewById(R.id.artistTV);
            yearTV = itemView.findViewById(R.id.nb_TracksTV);



        }
    }


}

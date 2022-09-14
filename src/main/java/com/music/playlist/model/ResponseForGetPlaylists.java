package com.music.playlist.model;

import java.util.List;

public class ResponseForGetPlaylists {

    private List<Playlist> playlists;

    public ResponseForGetPlaylists() {
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}

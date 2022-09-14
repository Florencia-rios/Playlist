package com.music.playlist.model;

import java.util.List;

public class RequestForCreatePlaylist {

    private String name;
    private List<Song> songs;

    public RequestForCreatePlaylist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}

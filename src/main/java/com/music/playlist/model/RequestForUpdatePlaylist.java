package com.music.playlist.model;

import java.util.List;
import java.util.UUID;

public class RequestForUpdatePlaylist {

    private UUID id;
    private List<Song> songs;
    /**
     * Si es 0 => es para agregar y 1 => es para quitar
     */
    private int flag;

    public RequestForUpdatePlaylist() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

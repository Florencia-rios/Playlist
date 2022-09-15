package com.music.playlist.model;

import java.util.List;

public class RequestForUpdatePlaylist {

    private Long id;
    private List<Song> songs;
    /**
     * Si es 0 => es para agregar y 1 => es para quitar
     */
    private int flag;

    public RequestForUpdatePlaylist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

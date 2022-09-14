package com.music.playlist.model;

import java.util.List;
import java.util.UUID;

public class Playlist {

    private UUID id;
    private String name;
    /**
     * Relacion OneToMany desde Playlist a Song
     */
    private List<Song> songs;

    public Playlist() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

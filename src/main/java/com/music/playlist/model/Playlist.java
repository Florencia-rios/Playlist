package com.music.playlist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PLAYLIST")
@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
public class Playlist {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JoinTable(
            name = "REL_PLAYLIST_SONG",
            joinColumns = @JoinColumn(name = "FK_PLAYLIST", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_SONG", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    List<Song> songs = new ArrayList<>();

    public Playlist() {
    }

    public void addSong(Song song){
        this.songs.add(song);
        song.getPlaylists().add(this);
    }

    public void removeSong(Song song){
        this.songs.remove(song);
        song.getPlaylists().remove(this);
    }

    public List<Song> getSongs() {
        return this.songs;
    }

}

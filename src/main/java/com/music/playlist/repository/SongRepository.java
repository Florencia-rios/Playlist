package com.music.playlist.repository;

import com.music.playlist.model.Playlist;
import com.music.playlist.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class SongRepository {

    public List<Playlist> findById(Long songId) {

        List<Playlist> playlists = new ArrayList<>();

        Playlist playlist = new Playlist();

        UUID id = UUID.randomUUID();

        List<Song> songs = new ArrayList<>();
        Song song = new Song();
        song.setId(songId);
        song.setAlbum("Album1");
        song.setArtist("Artista1");
        song.setTitle("Title1");
        songs.add(song);

        playlist.setId(id);
        playlist.setName("Lista1");
        playlist.setSongs(songs);

        playlists.add(playlist);

        return playlists;
    }
}

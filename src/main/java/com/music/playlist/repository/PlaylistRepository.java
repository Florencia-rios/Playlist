package com.music.playlist.repository;

import com.music.playlist.model.Playlist;
import com.music.playlist.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PlaylistRepository {

    /**
     *
     * @param playlist es la lista que se requiere crear en la db
     * @return la lista que se inserto
     */
    public Playlist save(Playlist playlist){ return playlist; };

    public Playlist findById(UUID id) {

        Playlist playlist = new Playlist();

        List<Song> songs = new ArrayList<>();
        Song song = new Song();
        song.setId(1L);
        song.setAlbum("Album1");
        song.setArtist("Artista1");
        song.setTitle("Title1");
        songs.add(song);

        playlist.setId(id);
        playlist.setName("Lista1");
        playlist.setSongs(songs);

        return playlist;
    }

    /**
     *
     * @param id
     * @param songs
     */
    public void updatePlaylist(UUID id, List<Song> songs) {
        // hacer query para actualizar
    }

    public void deleteById(UUID id) {
        //hacer query para borrar
    }
}

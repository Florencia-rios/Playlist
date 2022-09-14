package com.music.playlist.service;

import com.music.playlist.model.Playlist;
import com.music.playlist.model.Song;
import com.music.playlist.repository.PlaylistRepository;
import com.music.playlist.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    SongRepository songRepository;

    public Playlist createPlaylist(String name, List<Song> songs){
        UUID id = randomUUID();
        Playlist playlist = new Playlist();
        playlist.setId(id);
        playlist.setName(name);
        playlist.setSongs(songs);

        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(UUID id, List<Song> songs, int flag) {
        Playlist playlist = playlistRepository.findById(id);
        List<Song> currentSongs = playlist.getSongs();

        if (flag == 0){ // agregar
            songs.stream().filter(s -> currentSongs.add(s));
        } else if (flag == 1){
            songs.stream().filter(s -> currentSongs.remove(s));
        }

        playlist.setSongs(currentSongs);

        playlistRepository.updatePlaylist(id, currentSongs);

        return playlist;
    }

    public List<Playlist> getPlaylistsBySong(Long songId) {
       return songRepository.findById(songId);
    }

    public void detelePlaylist(UUID id) {
        playlistRepository.deleteById(id);
    }
}

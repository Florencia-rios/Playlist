package com.music.playlist.service;

import com.music.playlist.entity.Playlist;
import com.music.playlist.entity.Song;
import com.music.playlist.repository.PlaylistRepository;
import com.music.playlist.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;


    public Playlist createPlaylist(String name, List<Long> songIds){
        Playlist playlist = new Playlist();
        playlist.setName(name);

        System.out.println(songIds);
        for (Long songId: songIds){
            Song song = songRepository.findById(songId).orElseThrow();
            playlist.addSong(song);
        }

        playlistRepository.save(playlist);

        return playlist;
    }

    public Playlist addSongs(Long id, List<Long> songIds) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        for (Long songId: songIds){
            Song song = songRepository.findById(songId).orElseThrow();
            playlist.addSong(song);
        }

        playlistRepository.save(playlist);

        return playlist;
    }

    public Playlist removeSongs(Long id, List<Long> songIds) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        for (Long songId: songIds){
            Song song = songRepository.findById(songId).orElseThrow();
            playlist.removeSong(song);
        }

        playlistRepository.save(playlist);

        return playlist;
    }

    public List<Playlist> getPlaylistsBySong(Long songId) {
        Song song = songRepository.getById(songId);

        return song.getPlaylists();
    }

    public void detelePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

}

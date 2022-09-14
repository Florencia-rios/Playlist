package com.music.playlist.controller;

import com.music.playlist.model.Playlist;
import com.music.playlist.model.Song;
import com.music.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    public Playlist createPlaylist(String name, List<Song> songs){
        return playlistService.createPlaylist(name, songs);
    }

    public Playlist updatePlaylist(UUID id, List<Song> songs, int flag) {
        return playlistService.updatePlaylist(id, songs, flag);
    }

    public List<Playlist> getPlaylistsBySong(Long songId) {
        return playlistService.getPlaylistsBySong(songId);
    }

    public void detelePlaylist(UUID id) {
        playlistService.detelePlaylist(id);
    }
}

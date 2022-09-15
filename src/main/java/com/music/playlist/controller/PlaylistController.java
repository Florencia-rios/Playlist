package com.music.playlist.controller;

import com.music.playlist.model.Playlist;
import com.music.playlist.model.ResponseForGetPlaylists;
import com.music.playlist.model.Song;
import com.music.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    public Playlist createPlaylist(String name, List<Song> songs){
        return playlistService.createPlaylist(name, songs);
    }

  /*  public Playlist updatePlaylist(Long id, List<Song> songs, int flag) {
        return playlistService.updatePlaylist(id, songs, flag);
    }*/

    public ResponseForGetPlaylists getPlaylistsBySong(Long songId) {
        List<Playlist> playlists = playlistService.getPlaylistsBySong(songId);

        ResponseForGetPlaylists responseForGetPlaylists = new ResponseForGetPlaylists();
        responseForGetPlaylists.setPlaylists(playlists);

        return responseForGetPlaylists;
    }

    public void detelePlaylist(Long id) {
        playlistService.detelePlaylist(id);
    }
}

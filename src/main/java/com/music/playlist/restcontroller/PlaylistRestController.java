package com.music.playlist.restcontroller;

import com.music.playlist.controller.PlaylistController;
import com.music.playlist.model.Playlist;
import com.music.playlist.model.RequestForCreatePlaylist;
import com.music.playlist.model.RequestForUpdatePlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
public class PlaylistRestController {

    @Autowired
    PlaylistController playlistController;

    @PostMapping("/create-playlist")
    ResponseEntity<Playlist> createPlaylist(@RequestBody RequestForCreatePlaylist request) {
        return new ResponseEntity<>(playlistController.createPlaylist(request.getName(), request.getSongs()), HttpStatus.OK);
    }

    @PutMapping("/update-playlist")
    ResponseEntity<Playlist> updatePlaylist(@RequestBody RequestForUpdatePlaylist request) {
        return new ResponseEntity<>(playlistController.updatePlaylist(request.getId(), request.getSongs(), request.getFlag()), HttpStatus.OK);
    }

    @GetMapping("/get-playlists/{songId}")
    ResponseEntity<List<Playlist>> getPlaylistsBySong(@PathParam("songId") Long songId) {
        return new ResponseEntity<>(playlistController.getPlaylistsBySong(songId), HttpStatus.OK);
    }

    @DeleteMapping("/detele-playlist/{id}")
    void detelePlaylist(@PathParam("id") UUID id) {
        playlistController.detelePlaylist(id);
    }
}

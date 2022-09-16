package com.music.playlist.restcontroller;

import com.music.playlist.controller.PlaylistController;
import com.music.playlist.model.request.RequestForCreatePlaylist;
import com.music.playlist.model.request.RequestForUpdatePlaylist;
import com.music.playlist.model.response.ResponseForGetPlaylists;
import com.music.playlist.model.response.ResponsePlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaylistRestController {

    @Autowired
    PlaylistController playlistController;

    @PostMapping("/create-playlist")
    ResponseEntity<ResponsePlaylist> createPlaylist(@RequestBody RequestForCreatePlaylist request) {
        return new ResponseEntity<>(playlistController.createPlaylist(request.getName(), request.getSongIds()), HttpStatus.OK);
    }

    @PutMapping("/add-songs")
    ResponseEntity<ResponsePlaylist> addSongs(@RequestBody RequestForUpdatePlaylist request) {
        return new ResponseEntity<>(playlistController.addSongs(request.getId(), request.getSongIds()), HttpStatus.OK);
    }

    @PutMapping("/remove-songs")
    ResponseEntity<ResponsePlaylist> removeSongs(@RequestBody RequestForUpdatePlaylist request) {
        return new ResponseEntity<>(playlistController.removeSongs(request.getId(), request.getSongIds()), HttpStatus.OK);
    }

    @GetMapping("/get-playlists/{songId}")
    ResponseEntity<ResponseForGetPlaylists> getPlaylistsBySong(@PathVariable("songId") Long songId) {
        return new ResponseEntity<>(playlistController.getPlaylistsBySong(songId), HttpStatus.OK);
    }

    // TODO ver si se puede devolver un mensaje porque como es void no es específica la respuesta
    @DeleteMapping("/detele-playlist/{id}")
    void detelePlaylist(@PathVariable("id") Long id) {
        playlistController.detelePlaylist(id);
    }
}

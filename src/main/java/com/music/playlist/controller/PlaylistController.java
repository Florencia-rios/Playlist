package com.music.playlist.controller;

import com.music.playlist.entity.Playlist;
import com.music.playlist.entity.Song;
import com.music.playlist.model.dto.SongDto;
import com.music.playlist.model.response.ResponseForGetPlaylists;
import com.music.playlist.model.response.ResponsePlaylist;
import com.music.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    public ResponsePlaylist createPlaylist(String name, List<Long> songIds){

        System.out.println("controller: "+songIds);
        Playlist p = playlistService.createPlaylist(name, songIds);

        // TODO agregar un mapper
        // Mapeo la lista de canciones a una lista de canciones dto para setear a la respuesta final
        List<Song> currentSongs = p.getSongs();
        List<SongDto> songsResponse = new ArrayList<>();
        for (Song s: currentSongs) {
            SongDto songDto = new SongDto();
            songDto.setAlbum(s.getAlbum());
            songDto.setArtist(s.getArtist());
            songDto.setTitle(s.getTitle());

            songsResponse.add(songDto);
        }

        ResponsePlaylist responsePlaylist = new ResponsePlaylist();
        responsePlaylist.setName(p.getName());
        responsePlaylist.setSongs(songsResponse);

        return responsePlaylist;
    }

    public ResponsePlaylist addSongs(Long id, List<Long> songIds) {

        Playlist p = playlistService.addSongs(id, songIds);

        // TODO agregar un mapper
        // Mapeo la lista de canciones a una lista de canciones dto para setear a la respuesta final
        List<Song> currentSongs = p.getSongs();
        List<SongDto> songsResponse = new ArrayList<>();
        for (Song s: currentSongs) {
            SongDto songDto = new SongDto();
            songDto.setAlbum(s.getAlbum());
            songDto.setArtist(s.getArtist());
            songDto.setTitle(s.getTitle());

            songsResponse.add(songDto);
        }

        ResponsePlaylist responsePlaylist = new ResponsePlaylist();
        responsePlaylist.setName(p.getName());
        responsePlaylist.setSongs(songsResponse);

        return responsePlaylist;
    }

    public ResponsePlaylist removeSongs(Long id, List<Long> songIds) {

        Playlist p = playlistService.removeSongs(id, songIds);

        // TODO agregar un mapper
        // Mapeo la lista de canciones a una lista de canciones dto para setear a la respuesta final
        List<Song> currentSongs = p.getSongs();
        List<SongDto> songsResponse = new ArrayList<>();
        for (Song s: currentSongs) {
            SongDto songDto = new SongDto();
            songDto.setAlbum(s.getAlbum());
            songDto.setArtist(s.getArtist());
            songDto.setTitle(s.getTitle());

            songsResponse.add(songDto);
        }

        ResponsePlaylist responsePlaylist = new ResponsePlaylist();
        responsePlaylist.setName(p.getName());
        responsePlaylist.setSongs(songsResponse);

        return responsePlaylist;
    }

    public ResponseForGetPlaylists getPlaylistsBySong(Long songId) {
        List<Playlist> playlists = playlistService.getPlaylistsBySong(songId);

        List<ResponsePlaylist> playlists1 = new ArrayList<>();
        for(Playlist p: playlists){
            ResponsePlaylist responsePlaylist = new ResponsePlaylist();
            responsePlaylist.setName(p.getName());

            List<SongDto> songs = new ArrayList<>();
            for (Song s: p.getSongs()){
                SongDto songDto = new SongDto();
                songDto.setAlbum(s.getAlbum());
                songDto.setArtist(s.getArtist());
                songDto.setTitle(s.getTitle());
                songs.add(songDto);
            }
            responsePlaylist.setSongs(songs);

            playlists1.add(responsePlaylist);
        }

        ResponseForGetPlaylists responseForGetPlaylists = new ResponseForGetPlaylists();
        responseForGetPlaylists.setPlaylists(playlists1);

        return responseForGetPlaylists;
    }

    public void detelePlaylist(Long id) {
        playlistService.detelePlaylist(id);
    }
}

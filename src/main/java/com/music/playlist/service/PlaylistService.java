package com.music.playlist.service;

import com.music.playlist.model.Playlist;
import com.music.playlist.model.Song;
import com.music.playlist.repository.PlaylistRepo;
import com.music.playlist.repository.PlaylistRepository;
import com.music.playlist.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistRepo playlistRepos; //

    @Autowired
    private SongRepo songRepos; //

    public Playlist createPlaylist(String name, List<Song> songs){
        Playlist playlist = new Playlist();
        playlist.setName(name);
        for (Song song: songs) {
            playlist.addSong(song);
        }

        playlistRepos.save(playlist);

        return playlist;
    }

  /*  public Playlist updatePlaylist(Long id, List<Song> songs, int flag) {
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
    }*/

    public List<Playlist> getPlaylistsBySong(Long songId) {
        Song song = songRepos.getById(songId);
      //  System.out.println( song.getPlaylists().get(0));
        return song.getPlaylists();
    }

    public void detelePlaylist(Long id) {
        playlistRepos.deleteById(id);
    }
}

package com.music.playlist.repository;

import com.music.playlist.model.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {

    public List<Playlist> findById(Long songId) {
        return null;
    }
}

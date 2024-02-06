package com.music.playlist.repository;

import com.music.playlist.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//    @Query("Select * from Playlist where playlist.id := id ")
//    String ss(String id);
}

package com.music.playlist.model.response;

import com.music.playlist.model.dto.SongDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponsePlaylist {

    private String name;
    private List<SongDto> songs;

    public ResponsePlaylist() {
    }
}

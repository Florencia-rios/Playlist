package com.music.playlist.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseForGetPlaylists {

    private List<ResponsePlaylist> playlists;

    public ResponseForGetPlaylists() {
    }
}

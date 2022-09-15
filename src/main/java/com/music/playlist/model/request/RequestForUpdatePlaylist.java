package com.music.playlist.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestForUpdatePlaylist {

    private Long id;
    private List<Long> songIds;

    public RequestForUpdatePlaylist() {
    }

}

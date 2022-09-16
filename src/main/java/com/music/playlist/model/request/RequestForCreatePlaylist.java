package com.music.playlist.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestForCreatePlaylist {

    private String name;
    private List<Long> songIds;

    public RequestForCreatePlaylist() {
    }
}

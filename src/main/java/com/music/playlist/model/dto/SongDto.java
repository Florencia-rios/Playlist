package com.music.playlist.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDto {

    private String title;
    private String artist;
    private String album;

    public SongDto() {
    }
}

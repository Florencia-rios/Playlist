package com.music.playlist.restcontroller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.playlist.model.Playlist;
import com.music.playlist.model.RequestForCreatePlaylist;
import com.music.playlist.model.RequestForUpdatePlaylist;
import com.music.playlist.model.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PlaylistRestcontrollerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetPlaylistBySongIdThenReturnOk() throws Exception {
        // set up
        List<Playlist> playlists = new ArrayList<>();

        Playlist playlist = createPlaylist();

        playlists.add(playlist);

        // Mock
        this.mockMvc.perform(get("/get-playlists/{songId}", 1L)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void whenCreatePlaylistThenReturnPlaylist() throws Exception {
        // set up
        RequestForCreatePlaylist request = new RequestForCreatePlaylist();

        List<Song> songs = new ArrayList<>();
        Song song = createSong();
        songs.add(song);

        request.setName("Lista1");
        request.setSongs(songs);

        // Mock
        this.mockMvc.perform(post("/create-playlist").contentType(MediaType.APPLICATION_JSON).content(toJson(request))).andDo(print()).andExpect(status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lista1"));

    }

    // TODO falta terminarlo
    @Test
    public void whenUpdatePlaylistThenReturnPlaylistModified() throws Exception {
        // set up
        RequestForUpdatePlaylist request = new RequestForUpdatePlaylist();

        Playlist playlist = createPlaylist();


        // Mock
        this.mockMvc.perform(post("/update-playlist").contentType(MediaType.APPLICATION_JSON).content(toJson(playlist))).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lista1"));

    }

    private Playlist createPlaylist() {
        Playlist playlist = new Playlist();

        UUID id = UUID.randomUUID();

        List<Song> songs = new ArrayList<>();
        Song song = createSong();
        songs.add(song);

        playlist.setId(id);
        playlist.setName("Lista1");
        playlist.setSongs(songs);

        return playlist;
    }

    private Song createSong() {
        Song song = new Song();
        song.setId(1L);
        song.setAlbum("Album1");
        song.setArtist("Artista1");
        song.setTitle("Title1");
        return song;
    }

    private static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}

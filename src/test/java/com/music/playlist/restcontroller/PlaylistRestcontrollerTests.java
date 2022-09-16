package com.music.playlist.restcontroller;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.playlist.model.request.RequestForCreatePlaylist;
import com.music.playlist.model.request.RequestForUpdatePlaylist;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PlaylistRestcontrollerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserRestcontroller userRestcontroller;

    @Order(1)
    @Test
    public void whenCreatePlaylistThenReturnPlaylist() throws Exception {
        // set up
        RequestForCreatePlaylist request = new RequestForCreatePlaylist();

        List<Long> songIds = new ArrayList<>();
        songIds.add(1L);

        request.setName("Lista1");
        request.setSongIds(songIds);

        String token = getJWTToken("flor");

        // mock
        this.mockMvc.perform(post("/create-playlist").header("Authorization", token).contentType(MediaType.APPLICATION_JSON).content(toJson(request))).andDo(print()).andExpect(status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lista1"));

    }

    @Order(2)
    @Test
    public void whenAddSongsToPlaylistThenReturnPlaylistModified() throws Exception {
        // set up
        RequestForUpdatePlaylist request = new RequestForUpdatePlaylist();

        List<Long> songIds = new ArrayList<>();
        songIds.add(2L);

        request.setId(1L);
        request.setSongIds(songIds);

        String token = getJWTToken("flor");

        // mock
        this.mockMvc.perform(put("/add-songs").header("Authorization", token).contentType(MediaType.APPLICATION_JSON).content(toJson(request))).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lista1"));

    }

    @Order(3)
    @Test
    public void whenRemoveSongsToPlaylistThenReturnPlaylistModified() throws Exception {
        // set up
        RequestForUpdatePlaylist request = new RequestForUpdatePlaylist();

        List<Long> songIds = new ArrayList<>();
        songIds.add(2L);

        request.setId(1L);
        request.setSongIds(songIds);

        String token = getJWTToken("flor");

        // mock
        this.mockMvc.perform(put("/remove-songs").header("Authorization", token).contentType(MediaType.APPLICATION_JSON).content(toJson(request))).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lista1"));

    }

    @Order(4)
    @Test
    public void whenGetPlaylistBySongIdThenReturnOk() throws Exception {

        // set up
        String token = getJWTToken("flor");

        // mock
        this.mockMvc.perform(get("/get-playlists/{songId}", 1L).header("Authorization", token)).andDo(print()).andExpect(status().isOk());
    }

    @Order(5)
    @Test
    public void whenDeletePlaylistThenReturn200() throws Exception {

        // set up
        String token = getJWTToken("flor");

        // mock
        this.mockMvc.perform(delete("/detele-playlist/{id}", 2L).header("Authorization", token)).andDo(print()).andExpect(status().isOk());
    }


    private static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}

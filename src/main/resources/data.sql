INSERT INTO PLAYLIST (ID, NAME) VALUES (1,'Lista1');
INSERT INTO PLAYLIST (ID, NAME) VALUES (2,'Lista2');
INSERT INTO SONG (ID, TITLE, ARTIST, ALBUM) VALUES (1,'cancion1', 'artista1', 'album1');
INSERT INTO REL_PLAYLIST_SONG (FK_PLAYLIST, FK_SONG) VALUES (1, 1);
INSERT INTO REL_PLAYLIST_SONG (FK_PLAYLIST, FK_SONG) VALUES (2, 1);
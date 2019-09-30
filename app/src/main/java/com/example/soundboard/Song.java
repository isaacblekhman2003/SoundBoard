package com.example.soundboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Song {
    private List<Note> song;


    public Song(Note[] songs) {
        song = Arrays.asList(songs);
        song = new ArrayList<>();

    }

    public Song() {
        song = new ArrayList<>();
    }

    public void addNote(Note note) {
        song.add(note);
    }

    public void addNote(Note note, int location) {
        song.set(location, note);
    }

    public void removeNote(int location) {
        song.remove(location);
    }

    public int getSongLength() {
        return song.size();
    }
    public Note getNote(int location){

return song.get(location);

    }

}































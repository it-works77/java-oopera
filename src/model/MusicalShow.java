package model;

import java.util.ArrayList;

public class MusicalShow extends Show {
    private final String librettoText;
    private final Person musicAuthor; // TODO musicAuthor?

    public MusicalShow(String title, int duration, Director director, String libretto, Person musicAuthor) {
        super(title, duration, director);
        this.librettoText = libretto;
        this.musicAuthor = musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }
}

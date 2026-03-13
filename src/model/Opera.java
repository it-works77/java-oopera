package model;

import java.util.ArrayList;

public class Opera extends MusicalShow {
    private final int choirSize;

    public Opera(String title, int duration, Director director,
                 String libretto, Person musicAuthor, int choirSize) {
        super(title, duration, director, libretto, musicAuthor);
        this.choirSize = choirSize;
    }
}

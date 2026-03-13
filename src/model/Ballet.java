package model;

import java.util.ArrayList;

public class Ballet extends MusicalShow {
    public final Person choreographer;

    public Ballet(String title, int duration, Director director,
                  String libretto, Person musicAuthor, Person choreographer) {
        super(title, duration, director, libretto, musicAuthor);
        this.choreographer = choreographer;
    }
}

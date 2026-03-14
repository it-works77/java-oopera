package model;

import java.util.ArrayList;

public class Ballet extends MusicalShow {
    public final Person choreographer;

    // TODO ТЗ: Добавьте для новых классов конструкторы, содержащие все поля.
    public Ballet(String title, int duration, Director director,
                  String libretto, Person musicAuthor, Person choreographer) {
        super(title, duration, director, libretto, musicAuthor);
        this.choreographer = choreographer;
    }
}

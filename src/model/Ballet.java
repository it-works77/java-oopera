package model;

public class Ballet extends MusicalShow {
    public final Person choreographer;

    // ТЗ: Добавьте для новых классов конструкторы, содержащие все поля.
    public Ballet(String title, int duration, Director director,
                  String libretto, Person musicAuthor, Person choreographer) {
        super(title, duration, director, libretto, musicAuthor);
        this.choreographer = choreographer;
    }

    public Person getChoreographer() {
        return choreographer;
    }
}

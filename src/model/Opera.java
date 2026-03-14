package model;

public class Opera extends MusicalShow {
    private final int choirSize;

    // TODO ТЗ: Добавьте для новых классов конструкторы, содержащие все поля.
    public Opera(String title, int duration, Director director,
                 String libretto, Person musicAuthor, int choirSize) {
        super(title, duration, director, libretto, musicAuthor);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }
}

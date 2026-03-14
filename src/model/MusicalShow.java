package model;

public class MusicalShow extends Show {
    private final String librettoText;
    private final Person musicAuthor; // TODO musicAuthor?

    // TODO ТЗ: Добавьте для новых классов конструкторы, содержащие все поля.
    public MusicalShow(String title, int duration, Director director, String libretto, Person musicAuthor) {
        super(title, duration, director);
        this.librettoText = libretto;
        this.musicAuthor = musicAuthor;
    }

    public Person getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }
}

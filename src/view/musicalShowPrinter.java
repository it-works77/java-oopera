package view;

import model.Director;
import model.MusicalShow;
import model.Show;

public class musicalShowPrinter {
    public static void printLibretto(MusicalShow musicalShow) {
        System.out.println(musicalShow.getLibrettoText());
    }

    public static void printDirectorName(Show show) {
        Director director = show.getDirector();
        System.out.println("director = " + director);
    }
}

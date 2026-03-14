import controller.ApplicationController;
import model.*;
import util.PersonsGenerator;
import util.ShowGenerator;

public class Main {
    private static final String NOT_EXISTING_ACTOR_SURNAME = "Depp";
    private static final String EXISTING_ACTOR_SURNAME = PersonsGenerator.ACTOR_SURNAMES[0];
    private static final String ACTOR_FOR_SUBSTITUTION_SURNAME = PersonsGenerator.ACTOR_SURNAMES[2];
    private static final String SHOW_FROM = ShowGenerator.SHOWS[0];
    private static final String SHOW_TO = ShowGenerator.SHOWS[2];

    public static ApplicationController ac;

    public static void main(String[] args) {


        ac = new ApplicationController();

        ac.prepareShows();
        ac.printGreeting();

        // Создать трёх актеров и двух режиссёров.
        ac.prepareActors();

        // Распределить актёров по спектаклям. Используйте для этого метод добавления нового актёра в спектакль.
        // Один актёр может участвовать в нескольких спектаклях.
        ac.distributeActors();

        // Для каждого спектакля выведите на экран список актёров
        ac.printAllShowActors();

        // Замените актёра в одном из спектаклей на актёра из другого спектакля
        // и ещё раз выведите для него список актёров.
        Show showFrom = ac.getShow(SHOW_FROM);
        Show showTo = ac.getShow(SHOW_TO);

        if (showFrom == null && showTo == null) {
            System.out.println("Нет такого спекталя, проверьте название: '" + showFrom + "', '" + showTo + "'");
            return;
        }

        String sourceActorSurname = EXISTING_ACTOR_SURNAME;
        String destinationActorSurname = ACTOR_FOR_SUBSTITUTION_SURNAME;

        ac.printSubstitutionInfo(showFrom, showTo, sourceActorSurname, destinationActorSurname);
        ac.substituteActor(showFrom, showTo, sourceActorSurname, destinationActorSurname);

        // Попробуйте заменить в другом спектакле несуществующего актёра
        sourceActorSurname = EXISTING_ACTOR_SURNAME;
        destinationActorSurname = NOT_EXISTING_ACTOR_SURNAME;

        ac.printSubstitutionInfo(showFrom, showTo, sourceActorSurname, destinationActorSurname);
        ac.substituteActor(showFrom, showTo, sourceActorSurname, destinationActorSurname);

        ac.printAllShowActors();

        // Для оперного и балетного спектакля выведите на экран текст либретто
        ac.printLibretto();

    }
}

package model;

import java.util.ArrayList;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        listOfActors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void addActor(Actor actor) {
        /* Добавить нового актёра в спектакль. При добавлении актёра должна быть проверка,
         * нет ли уже такого актёра среди добавленных. Если есть, должно выводиться предупреждающее сообщение,
         * и актёр не должен добавляться. Актёры считаются одинаковыми,
         * если у них совпадают имя, фамилия и рост.
         * */

        if (listOfActors.contains(actor)) {
            System.out.println("Актер уже участвует в спектакле: " + actor);
        } else {
            listOfActors.add(actor);
        }

    }

    public void substituteActor(Actor actor, String surnameToSubstitute) {
        /* Заменить одного актёра в спектакле на другого (на вход подаётся объект нового актёра
         * и фамилия того, которого он заменяет).
         * Если актёр с такой фамилией отсутствует, должно выводиться предупреждающее сообщение.
         * Порядок актёров в списке значения не имеет
         * */

        // Замечание: Можно попробовать обработать ситуацию, когда актер с такой фамилией уже есть в спектакле
        // Проверим не только фамилию, а наличие объекта актера
        if (listOfActors.contains(actor)) {
            System.out.println("Актер " + actor.getSurname() + " уже участвует в спектакле");
            return;
        }

        int index = -1;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equals(surnameToSubstitute)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Такого актера в спектакле нет: " + surnameToSubstitute);
        } else {
            listOfActors.set(index, actor);
        }
    }

    @Override
    public String toString() {
        return "Show{" +
                "director=" + director +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                '}';
    }

    public Actor getActor(String actorSurname) {
        int index = -1;

        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equals(actorSurname)) {
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        return listOfActors.get(index);
    }
}

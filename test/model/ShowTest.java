package model;

import controller.ApplicationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.PersonsGenerator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ShowTest {
    private ArrayList<Show> shows;
    private ArrayList<Actor> actors;
    private Actor notExistingActor;

    @BeforeEach
    void setUp() {
        ApplicationController ac = new ApplicationController();
        ac.prepareShows();
        shows = ac.getShows();
        actors = PersonsGenerator.generateActors();
        int HEIGHT = 180;
        notExistingActor = new Actor("AAA", "BBB", Gender.FEMALE, HEIGHT);
    }

    @Test
    void addNewActor() {
        Show s = shows.getFirst();
        s.addActor(notExistingActor);
        assertTrue(s.getListOfActors().contains(notExistingActor));
    }

    @Test
    void addExistingActor() {
        Show s = shows.getFirst();
        s.addActor(actors.getFirst());

        int actorsNumBefore = s.getListOfActors().size();

        s.addActor(actors.getFirst());

        // Список актеров не должен измениться при добавлении имеющегося
        assertEquals(actorsNumBefore, s.getListOfActors().size());
    }

    @Test
    void substituteNotExistingActor() {
        Show s = shows.getFirst();
        s.addActor(actors.getFirst());

        Actor actorToSubstitute = s.getListOfActors().getFirst();

        s.substituteActor(notExistingActor, actorToSubstitute.getSurname());
        assertTrue(s.getListOfActors().contains(notExistingActor));
        assertFalse(s.getListOfActors().contains(actorToSubstitute));
    }

    @Test
    void substituteExistingActor() {
        Show s = shows.getFirst();

        Actor sourceActor = actors.get(0);
        Actor destinationActor = actors.get(1);
        s.addActor(sourceActor);
        s.addActor(destinationActor);

        int actorsNumBefore = s.getListOfActors().size();
        s.substituteActor(sourceActor, destinationActor.getSurname());

        // Список должен содержать актера, которого пытались заменить
        assertTrue(s.getListOfActors().contains(destinationActor));

        // Длина списка не изменилась
        assertEquals(actorsNumBefore, s.getListOfActors().size());

    }
}
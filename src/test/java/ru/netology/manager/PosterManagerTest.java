package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieUnit;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    private PosterManager manager = new PosterManager(10);

    private MovieUnit first = new MovieUnit(1, 1, "first", 1, "../poster/filmName.png");
    private MovieUnit second = new MovieUnit(2, 2, "second", 2, "../poster/filmName.png");
    private MovieUnit third = new MovieUnit(3, 3, "third", 4, "../poster/filmName.png");
    private MovieUnit fourth = new MovieUnit(4, 4, "fourth", 3, "../poster/filmName.png");
    private MovieUnit fifth = new MovieUnit(5, 5, "fifth", 2, "../poster/filmName.png");
    private MovieUnit sixth = new MovieUnit(6, 6, "sixth", 6, "../poster/filmName.png");
    private MovieUnit seventh = new MovieUnit(7, 7, "seventh", 4, "../poster/filmName.png");
    private MovieUnit eighth = new MovieUnit(8, 8, "eighth", 2, "../poster/filmName.png");
    private MovieUnit ninth = new MovieUnit(9, 9, "ninth", 5, "../poster/filmName.png");
    private MovieUnit tenth = new MovieUnit(10, 10, "tenth", 5, "../poster/filmName.png");
    private MovieUnit eleventh = new MovieUnit(11, 11, "eleventh", 1, "../poster/filmName.png");
    private MovieUnit twelfth = new MovieUnit(12, 12, "twelfth", 3, "../poster/filmName.png");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    // twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first
    @Test
    public void shouldGetOnlyCertainPosters() {
        manager.getCertainPoster();
    }

    @Test
    public void createWithoutArguments(){
        PosterManager manager = new PosterManager();
        manager.add(first);
    }

    @Test
    public void createManagerWithItemsLowestGetCertain(){
        PosterManager manager = new PosterManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.getCertainPoster();
    }

    @Test
    public void useSettersInMovieUnit(){
        MovieUnit testMovieUnit = new MovieUnit();
        testMovieUnit.setId(1001);
        testMovieUnit.setMovieId(202);
        testMovieUnit.setMovieTitle("Pulp fiction");
        testMovieUnit.setGenreId(2);
        testMovieUnit.setPosterUrl("../poster.png");
        //MovieUnit(1001, 202, "Pulp fiction", 2, "../picture.png")
        assertEquals(testMovieUnit.getId(), 1001);
        assertEquals(testMovieUnit.getMovieId(), 202);
        assertEquals(testMovieUnit.getMovieTitle(), "Pulp fiction");
        assertEquals(testMovieUnit.getGenreId(), 2);
        assertEquals(testMovieUnit.getPosterUrl(), "../poster.png");
    }

    @Test
    public void equalsTest(){
        MovieUnit firstMovieUnit = new MovieUnit();
        MovieUnit secondMovieUnit = new MovieUnit();
        firstMovieUnit.equals(secondMovieUnit);
        secondMovieUnit.equals(firstMovieUnit);
        assertEquals(firstMovieUnit.hashCode(), secondMovieUnit.hashCode());
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        MovieUnit[] actual = manager.getAll();
        MovieUnit[] expected = new MovieUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 2;

        manager.removeById(idToRemove);

        MovieUnit[] actual = manager.getAll();
        MovieUnit[] expected = new MovieUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, first};

        assertArrayEquals(expected, actual);
    }
}
package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieUnit;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository repository = new MovieRepository();

    MovieUnit first = new MovieUnit(1, 1, "first", 1, "../poster/filmName.png");
    MovieUnit second = new MovieUnit(2, 2, "second", 2, "../poster/filmName.png");
    MovieUnit third = new MovieUnit(3, 3, "third", 4, "../poster/filmName.png");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldAdd(){
        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll(){
        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById(){
        MovieUnit[] actual = repository.findById(2);
        MovieUnit[] expected = new MovieUnit[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfNotExist(){
        MovieUnit[] actual = repository.findById(7);
        MovieUnit[] expected = new MovieUnit[]{null};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById(){
        repository.removeById(2);
        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNotExist(){
        repository.removeById(5);
        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll(){
        repository.removeAll();
        MovieUnit[] actual = repository.findAll();
        MovieUnit[] expected = new MovieUnit[0];
        assertArrayEquals(expected, actual);
    }
}
package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieUnit;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class PosterManagerTest {
    @Mock
    MovieRepository repository;

    @InjectMocks
    PosterManager manager;

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

    @Test
    public void usePosterManagerWithItemsAmountLowestCertain(){
        PosterManager manager = new PosterManager(5, repository);
        MovieUnit[] returned = new MovieUnit[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        MovieUnit[] actual = manager.getCertainPoster();
        MovieUnit[] expected = new MovieUnit[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void usePosterManagerWithItemsAmountHighestCertain(){
        PosterManager manager = new PosterManager(5, repository);
        MovieUnit[] returned = new MovieUnit[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();
        MovieUnit[] actual = manager.getCertainPoster();
        MovieUnit[] expected = new MovieUnit[]{seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {
        PosterManager manager = new PosterManager(10, repository);
        MovieUnit[] returned = new MovieUnit[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        MovieUnit[] actual = manager.getCertainPoster();
        MovieUnit[] expected = new MovieUnit[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 3;
        MovieUnit[] returned = new MovieUnit[]{first, second, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        MovieUnit[] actual = manager.getAll();
        MovieUnit[] expected = new MovieUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 53;
        MovieUnit[] returned = new MovieUnit[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        MovieUnit[] actual = manager.getAll();
        MovieUnit[] expected = new MovieUnit[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void useMethodAdd(){
        PosterManager manager = new PosterManager(3, repository);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        MovieUnit[] returned = new MovieUnit[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        MovieUnit[] actual = manager.getCertainPoster();
        MovieUnit[] expected = new MovieUnit[]{third, second, first};
        assertArrayEquals(expected, actual);
    }
}
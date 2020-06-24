package ru.netology.manager;

import ru.netology.domain.MovieUnit;
import ru.netology.repository.MovieRepository;

public class PosterManager {
    private int certainAmount = 10;

    private MovieRepository repository = new MovieRepository();

    public PosterManager(int certainAmount, MovieRepository repository) {
        this.certainAmount = certainAmount;
        this.repository = repository;
    }

    public PosterManager() {
    }

    public void add(MovieUnit item) {
        repository.save(item);
    }

    public MovieUnit[] getAll() {
        MovieUnit[] items = repository.findAll();
        MovieUnit[] result = new MovieUnit[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public MovieUnit[] getCertainPoster() {
        MovieUnit[] items = repository.findAll();
        int certainLength = certainAmount < items.length ? certainAmount : items.length;
        MovieUnit[] result = new MovieUnit[certainLength];
        for (int i = 0; i < certainLength; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
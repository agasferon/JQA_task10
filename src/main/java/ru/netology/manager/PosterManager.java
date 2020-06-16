package ru.netology.manager;

import ru.netology.domain.MovieUnit;
import ru.netology.repository.MovieRepository;

public class PosterManager {
    private int certainAmount = 10;

    private MovieRepository repository = new MovieRepository();

    public PosterManager(int certainAmount) {
        this.certainAmount = certainAmount;
    }

    public PosterManager() {
    }

    public void setCertainAmount(int certainAmount) {
        this.certainAmount = certainAmount;
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
        MovieUnit[] result = new MovieUnit[items.length];

        if (items.length > certainAmount) {
            for (int i = 0; i < certainAmount; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
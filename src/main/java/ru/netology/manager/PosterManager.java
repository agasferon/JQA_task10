package ru.netology.manager;

import ru.netology.domain.MovieUnit;

public class PosterManager {
    private int certainAmount = 10;
    private MovieUnit[] items = new MovieUnit[0];

    public PosterManager(int certainAmount) {
        this.certainAmount = certainAmount;
    }

    public PosterManager() {
    }

    public void add(MovieUnit item) {
        int length = items.length + 1;
        MovieUnit[] tmp = new MovieUnit[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieUnit[] getAll() {
        MovieUnit[] result = new MovieUnit[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public MovieUnit[] getCertainPoster() {
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
        if (id <= items.length) {
        int length = items.length - 1;
        MovieUnit[] tmp = new MovieUnit[length];
        int index = 0;
            for (MovieUnit item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}
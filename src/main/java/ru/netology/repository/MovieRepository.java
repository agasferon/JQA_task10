package ru.netology.repository;

import ru.netology.domain.MovieUnit;

public class MovieRepository {
    private MovieUnit[] items = new MovieUnit[0];

    public void save(MovieUnit item) {
        int length = items.length + 1;
        MovieUnit[] tmp = new MovieUnit[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieUnit[] findAll() {
        return items;
    }

    public MovieUnit[] findById(int id) {
        MovieUnit[] tmp = new MovieUnit[1];
        int index = 0;
        for (MovieUnit item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        return tmp;
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

    public void removeAll(){
        items = new MovieUnit[0];
    }
}
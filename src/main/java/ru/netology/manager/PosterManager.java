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
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        MovieUnit[] tmp = new MovieUnit[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieUnit[] getAll() {
        MovieUnit[] result = new MovieUnit[items.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
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
                System.out.println(items[index]);
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
                System.out.println(items[index]);
            }
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        MovieUnit[] tmp = new MovieUnit[length];
        int index = 0;
        for (MovieUnit item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }
}
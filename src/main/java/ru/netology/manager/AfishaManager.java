package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class AfishaManager {
    private MovieItem[] movies = new MovieItem[0];
    private int maxShow = 10;

    public void add(MovieItem item) {
        int length = movies.length + 1;
        MovieItem[] onScreen = new MovieItem[length];
        System.arraycopy(movies, 0, onScreen, 0, movies.length);
        int lastIndex = onScreen.length - 1;
        onScreen[lastIndex] = item;
        movies = onScreen;
    }

    public MovieItem[] getAll() {
        int lengthResult = maxShow;
        if (movies.length < maxShow) {
            lengthResult = movies.length;
        }
        MovieItem[] result = new MovieItem[lengthResult];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
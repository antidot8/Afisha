package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    MovieItem movie1 = new MovieItem(1, 1, "movie1", 1, "http://image1.com");
    MovieItem movie2 = new MovieItem(2, 2, "movie2", 1, "http://image2.com");
    MovieItem movie3 = new MovieItem(3, 3, "movie3", 1, "http://image3.com");
    MovieItem movie4 = new MovieItem(4, 4, "movie4", 1, "http://image4.com");
    MovieItem movie5 = new MovieItem(5, 5, "movie5", 1, "http://image5.com");
    MovieItem movie6 = new MovieItem(6, 6, "movie6", 1, "http://image6.com");
    MovieItem movie7 = new MovieItem(7, 7, "movie7", 1, "http://image7.com");
    MovieItem movie8 = new MovieItem(8, 8, "movie8", 1, "http://image8.com");
    MovieItem movie9 = new MovieItem(9, 9, "movie9", 1, "http://image9.com");
    MovieItem movie10 = new MovieItem(10, 10, "movie10", 1, "http://image10.com");
    MovieItem movie11 = new MovieItem(11, 11, "movie11", 1, "http://image11.com");

    @Test
    public void addMovieIfEmpty() {
        MovieItem[] expected = new MovieItem[]{movie1};
        manager.add(movie1);
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void addMovieIfIdExist() {  // логики на проверку наличия одинаковых фильмов нет, но тест оставил на всякий случай
        MovieItem[] expected = new MovieItem[]{movie1, movie1};
        manager.add(movie1);
        manager.add(movie1);
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void sortMovieIfFull() {
        MovieItem[] expected = new MovieItem[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
        manager.add(movie11);
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void sortMovieIfSomeExist() {
        MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void showMovieIfEmpty() {
        MovieItem[] expected = new MovieItem[0];
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void showMovieIfChangeLimit() {
        AfishaManager manager = new AfishaManager(3);
        MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        assertArrayEquals(expected, manager.getAll());
    }
}
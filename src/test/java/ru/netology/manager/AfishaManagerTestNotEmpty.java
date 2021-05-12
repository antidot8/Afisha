package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTestNotEmpty {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    MovieItem movie1 = new MovieItem(1, 1, "movie1", 1, "http://image1.com");
    MovieItem movie2 = new MovieItem(2, 2, "movie2", 1, "http://image2.com");
    MovieItem movie3 = new MovieItem(3, 3, "movie3", 1, "http://image3.com");
    MovieItem movie4 = new MovieItem(4, 4, "movie4", 1, "http://image4.com");

    @BeforeEach
    public void setUp() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
    }

    @Test
    public void removeIdIfExist() {
        int idToRemove = 2;
        MovieItem[] returned = new MovieItem[]{movie1, movie3};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[]{movie3, movie1};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void addIdIfNotEmpty() {
        MovieItem idToAdd = movie4;
        MovieItem[] returned = new MovieItem[]{movie1, movie2, movie3, movie4};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(idToAdd);
        manager.add(movie4);
        MovieItem[] expected = new MovieItem[]{movie4, movie3, movie2, movie1};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).save(idToAdd);
    }

    @Test
    public void showIfNotEmpty() {
        MovieItem[] returned = new MovieItem[]{movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();
        MovieItem[] expected = new MovieItem[]{movie3, movie2, movie1};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void removeAllIfNotEmpty() {
        MovieItem[] returned = new MovieItem[0];
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeAll();
        repository.removeAll();
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeAll();
    }

    @Test
    public void findByIdIfIdExist() {
        int idForSearch = 3;
        MovieItem[] returned = new MovieItem[]{movie3};
        doReturn(returned).when(repository).findById(idForSearch);
        doReturn(returned).when(repository).findAll();
        repository.findById(idForSearch);
        MovieItem[] expected = new MovieItem[]{movie3};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findById(idForSearch);
    }

    @Test
    public void findByIdIfIdNotExist() {
        int idForSearch = 4;
        MovieItem[] returned = new MovieItem[0];
        doReturn(returned).when(repository).findById(idForSearch);
        doReturn(returned).when(repository).findAll();
        repository.findById(idForSearch);
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findById(idForSearch);
    }
}
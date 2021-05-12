package ru.netology.manager;

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
public class AfishaManagerTestEmpty {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    MovieItem movie1 = new MovieItem(1, 1, "movie1", 1, "http://image1.com");

    @Test
    public void removeIdIfEmpty() {
        int idToRemove = 2;
        MovieItem[] returned = new MovieItem[0];
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void addIdIfEmpty() {
        MovieItem idToAdd = movie1;
        MovieItem[] returned = new MovieItem[]{movie1};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(idToAdd);
        manager.add(movie1);
        MovieItem[] expected = new MovieItem[]{movie1};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).save(idToAdd);
    }

    @Test
    public void showIfEmpty() {
        MovieItem[] returned = new MovieItem[0];
        doReturn(returned).when(repository).findAll();
        MovieItem[] expected = new MovieItem[0];
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void removeAllIfEmpty() {
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
    public void findByIdIfEmpty() {
        int idForSearch = 3;
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
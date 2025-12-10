package com.demo.bookstore_app.service;

import com.demo.bookstore_app.models.Book;
import com.demo.bookstore_app.repositories.BookRepository;
import com.demo.bookstore_app.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = Arrays.asList(
                new Book ("Book 1", 20.00, "Author 1", "Novel", 2025),
                new Book ("Book 2", 35.00, "Author 2", "Fiction", 1987)
        );
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();
        assertEquals(2, result.size());
    }

    @Test
    public void testSaveBook() throws Exception {
        Book bookToSave = new Book(null, "Book 1", 25.00, "Author 2", "Horror", 2020);
        Book savedBook = new Book(10L, "Book 1", 25.00, "Author 2", "Horror", 2020);

        when(bookRepository.save(bookToSave)).thenReturn(savedBook);

        Book result = bookService.saveBook(bookToSave);

        assertNotNull(result);
        assertEquals(savedBook.getBookId(), result.getBookId());
    }

    @Test
    public void testDeleteBook() throws Exception {
        Long id = 10L;

        bookService.deleteBook(id);

        verify(bookRepository, times(1)).deleteById(id);
    }
}

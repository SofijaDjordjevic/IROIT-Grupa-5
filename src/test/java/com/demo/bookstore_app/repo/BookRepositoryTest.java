package com.demo.bookstore_app.repo;

import com.demo.bookstore_app.models.Book;
import com.demo.bookstore_app.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void testFindBookByName(){
        Book book = new Book();
        String testTitle = "The Little prince";
        book.setBookName(testTitle);

        repository.save(book);
        List<Book> foundBooks = repository.findByBookNameContainingIgnoreCase(testTitle);

        assertFalse(foundBooks.isEmpty(),  "The list should not be empty");
    }

    @Test
    public void testSave(){
        Book book = new Book( null, "Book A", 20.00, "Author 1", "Genre 1", 2024);
        repository.save(book);

        Long bookID = book.getBookId();
        Book savedBook = repository.findById(bookID).orElseThrow();

        assertEquals(bookID, savedBook.getBookId());
        assertEquals("Book A", savedBook.getBookName());
        assertEquals(Double.valueOf(20.00), savedBook.getBookPrice());
        assertEquals(2024, savedBook.getPublishingYear());
    }
}

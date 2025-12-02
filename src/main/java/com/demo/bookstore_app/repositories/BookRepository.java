package com.demo.bookstore_app.repositories;

import com.demo.bookstore_app.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByBookNameContainingIgnoreCase(String title);
    List<Book> findByBookGenreContainingIgnoreCase(String genre);
    List<Book> findByAuthorNameContainingIgnoreCase(String author);

    List<Book> findByBookPriceBetween(Double minPrice, Double maxPrice);
    @Query("SELECT b.bookGenre, COUNT(b) FROM book b GROUP BY b.book_genre")
    List<Object[]> countBooksByGenre();
}

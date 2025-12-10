package com.demo.bookstore_app.controller;

import com.demo.bookstore_app.models.Book;
import com.demo.bookstore_app.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testUpdateBook() throws Exception {
        Book existingBook = bookRepository.save(new Book(null, "Existing Book", 19.99, "Existing Author", "Genre 1", 2007));

        Book updatedBook = new Book(existingBook.getBookId(), "Updated Book", 19.99, "Author 5", "Genre 1", 2007);

       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/book/{bookId}", existingBook.getBookId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Book modifiedBook = objectMapper.readValue(result.getResponse().getContentAsString(), Book.class);

        assertEquals(existingBook.getBookId(),modifiedBook.getBookId());
        assertEquals(updatedBook.getBookName(), modifiedBook.getBookName());
        assertEquals(updatedBook.getAuthorName(), modifiedBook.getAuthorName());
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book existingBook = bookRepository.save(new Book(null, "Existing Book", 19.99, "Existing Author", "Genre 1", 2007));

        mockMvc.perform(MockMvcRequestBuilders.delete("/book/{bookId}",existingBook.getBookId()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        assertFalse(bookRepository.existsById(existingBook.getBookId()));
    }
}

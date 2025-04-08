package com.Zynetic.bookStore.repository;

import com.Zynetic.bookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);

    List<Book> findByRating(Double rating);

    //CUSTOM query for title
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%',:title, '%'))")
    List<Book> searchByTitle(String title);

}

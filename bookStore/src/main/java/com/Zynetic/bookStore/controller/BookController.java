package com.Zynetic.bookStore.controller;

import com.Zynetic.bookStore.model.Book;
import com.Zynetic.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAll(@RequestParam(required = false) String author,
                                             @RequestParam(required = false) String category,
                                             @RequestParam(required = false) Double rating,
                                             @RequestParam(required = false) String search) {
        if (search != null) return ResponseEntity.ok(bookService.searchByTitle(search));
        return ResponseEntity.ok(bookService.filter(author, category, rating));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        return bookService.getBookById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}


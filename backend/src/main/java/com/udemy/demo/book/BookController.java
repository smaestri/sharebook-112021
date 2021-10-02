package com.udemy.demo.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class BookController {

    @GetMapping("books")
    public ResponseEntity list() {
        Book book = new Book();
        book.setTitle("title");
        book.setCategory(new Category("BD"));
        return new ResponseEntity<>(Arrays.asList(book), HttpStatus.OK);
    }

    @PostMapping("books")
    public ResponseEntity create(@Valid @RequestBody Book book) {

        return new ResponseEntity(book, HttpStatus.CREATED);

    }

    @DeleteMapping("books/{bookId}")
    public ResponseEntity delete(@PathVariable("bookId") String bookId) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PutMapping("books/{bookId}")
    public ResponseEntity update(@PathVariable("bookId") String bookId, @RequestBody Book book) {

        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/categories")
    public ResponseEntity listCat() {
        Category cat = new Category("BD");
        Category catRoman = new Category("Roman");

        return new ResponseEntity<>(Arrays.asList(cat, catRoman), HttpStatus.OK);
    }



}

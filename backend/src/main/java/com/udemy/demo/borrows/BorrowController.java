package com.udemy.demo.borrows;

import com.udemy.demo.book.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
public class BorrowController {

    @GetMapping("/borrows")
    public ResponseEntity list() {
        Borrow borrow = new Borrow();
        borrow.setAskDate(LocalDate.now());
        return new ResponseEntity(borrow, HttpStatus.OK);
    }

    @PostMapping("/borrows/{bookId}")
    public ResponseEntity create(@PathVariable("bookId") String bookId) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/borrows/{borrowId}")
    public ResponseEntity delete(@PathVariable("borrowId") String borrowId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
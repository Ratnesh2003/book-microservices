package org.ratnesh.bookservice.controller;

import lombok.RequiredArgsConstructor;
import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.dto.ErrorDTO;
import org.ratnesh.bookservice.exception.BookNotFoundException;
import org.ratnesh.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBook() {
        try {
            return ResponseEntity.ok(bookService.getAllBook());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(bookService.getBookById(id));
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}

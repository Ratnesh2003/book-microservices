package org.ratnesh.bookservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.dto.ErrorDTO;
import org.ratnesh.bookservice.exception.BookNotFoundException;
import org.ratnesh.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("/exists/{id}")
    public ResponseEntity<?> existsBookById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(bookService.existsBookById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @DeleteMapping("/{id}")
    @CircuitBreaker(name = "inventory", fallbackMethod = "deleteBookFallback")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteBookFallback(Exception e) {
        log.error("Fallback method called");
        if (e instanceof BookNotFoundException) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        if (e instanceof ConnectException) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorDTO(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE));
        }
        log.error("Unknown error occurred", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

}

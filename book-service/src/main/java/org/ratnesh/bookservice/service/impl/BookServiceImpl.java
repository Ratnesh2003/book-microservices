package org.ratnesh.bookservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.dto.BookResponse;
import org.ratnesh.bookservice.entity.Book;
import org.ratnesh.bookservice.exception.BookAlreadyExistsException;
import org.ratnesh.bookservice.exception.BookNotFoundException;
import org.ratnesh.bookservice.repository.BookRepository;
import org.ratnesh.bookservice.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public String createBook(BookRequest request) {
        if (bookRepository.existsByName(request.getName())) {
            throw new BookAlreadyExistsException();
        }
        var book = new Book(request);
        book = bookRepository.save(book);

        log.info("Book created with id: {}", book.getId());

        return book.getId();
    }

    @Override
    public List<BookResponse> getAllBook() {
        return bookRepository.findAll().stream().map(Book::toBookResponse).toList();
    }

    @Override
    public BookResponse getBookById(String id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        }
        return bookRepository.findById(id).map(Book::toBookResponse).orElse(null);
    }

}

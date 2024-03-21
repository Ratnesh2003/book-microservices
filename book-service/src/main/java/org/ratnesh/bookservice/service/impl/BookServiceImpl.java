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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final WebClient.Builder webClientBuilder;

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
    public Page<BookResponse> getAllBook(int pageIndex, int pageSize, String sortBy, Sort.Direction sortDirection) {
        var pageRequest = PageRequest.of(pageIndex, pageSize, sortDirection, sortBy);

        return bookRepository.findAll(pageRequest).map(Book::toBookResponse);
    }

    @Override
    public BookResponse getBookById(String id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        }
        return bookRepository.findById(id).map(Book::toBookResponse).orElse(null);
    }

    @Override
    public void deleteBookById(String id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        }
        deleteBookFromInventory(id);
        bookRepository.deleteById(id);
    }

    @Override
    public boolean existsBookById(String bookId) {
        return bookRepository.existsById(bookId);
    }

    private void deleteBookFromInventory(String bookId) {
        webClientBuilder.build().delete()
                .uri("http://inventory-service/api/inventory/" + bookId)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}

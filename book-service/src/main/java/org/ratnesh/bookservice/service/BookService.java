package org.ratnesh.bookservice.service;

import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.dto.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    String createBook(BookRequest request);

    List<BookResponse> getAllBook();

    BookResponse getBookById(String id);

}

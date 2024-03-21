package org.ratnesh.bookservice.service;

import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.dto.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    String createBook(BookRequest request);

    Page<BookResponse> getAllBook(int pageIndex, int pageSize, String sortBy, Sort.Direction sortDirection);

    BookResponse getBookById(String id);

    void deleteBookById(String id);

    boolean existsBookById(String bookId);
}

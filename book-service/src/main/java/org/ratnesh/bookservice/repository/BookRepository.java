package org.ratnesh.bookservice.repository;

import org.ratnesh.bookservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    boolean existsByName(String name);
}

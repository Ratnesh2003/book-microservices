package org.ratnesh.bookservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.dto.BookResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "book")
@NoArgsConstructor
@Data
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    private String description;
    private Long price;
    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public Book(BookRequest request) {
        this.name = request.getName();
        this.author = request.getAuthor();
        this.description = request.getDescription();
        this.price = request.getPrice();
    }

    public BookResponse toBookResponse() {
        return modelMapper.map(this, BookResponse.class);
    }
}

package org.ratnesh.bookservice.dto;

import lombok.Data;

@Data
public class BookResponse {
    private String id;
    private String name;
    private String author;
    private String description;
    private Long price;
}

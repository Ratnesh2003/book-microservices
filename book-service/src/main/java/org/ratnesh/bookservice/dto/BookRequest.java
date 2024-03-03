package org.ratnesh.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String author;
    private String description;
    private Long price;
}

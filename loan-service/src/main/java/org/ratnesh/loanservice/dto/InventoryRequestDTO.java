package org.ratnesh.loanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryRequestDTO {
    private String bookId;
    private Long quantity;
}

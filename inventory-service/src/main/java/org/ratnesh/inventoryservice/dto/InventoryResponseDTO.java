package org.ratnesh.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryResponseDTO {
    private Long id;
    private String bookId;
    private Long quantity;
}

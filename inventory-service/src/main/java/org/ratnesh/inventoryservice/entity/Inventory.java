package org.ratnesh.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.ratnesh.inventoryservice.dto.InventoryRequestDTO;
import org.ratnesh.inventoryservice.dto.InventoryResponseDTO;

@Entity
@NoArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookId;
    private Long quantity;
    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public Inventory(InventoryRequestDTO request) {
        this.bookId = request.getBookId();
        this.quantity = request.getQuantity();
    }

    public InventoryResponseDTO toResponseDTO() {
        return modelMapper.map(this, InventoryResponseDTO.class);
    }
}

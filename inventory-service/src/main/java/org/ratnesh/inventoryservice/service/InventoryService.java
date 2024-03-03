package org.ratnesh.inventoryservice.service;

import org.ratnesh.inventoryservice.dto.InventoryRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface InventoryService {

    Long getAvailability(String bookId);

    void updateAvailability(InventoryRequestDTO request);

    void addBookInInventory(InventoryRequestDTO request);
}

package org.ratnesh.inventoryservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.ratnesh.inventoryservice.dto.InventoryRequestDTO;
import org.ratnesh.inventoryservice.entity.Inventory;
import org.ratnesh.inventoryservice.exception.BookEntryAlreadyExistsException;
import org.ratnesh.inventoryservice.exception.BookNotFoundException;
import org.ratnesh.inventoryservice.repository.InventoryRepository;
import org.ratnesh.inventoryservice.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Long getAvailability(String bookId) throws BookNotFoundException {
        var inventory = inventoryRepository.findByBookId(bookId).orElseThrow(BookNotFoundException::new);
        return inventory.getQuantity();
    }

    @Override
    public void updateAvailability(InventoryRequestDTO request) throws BookNotFoundException {
        var inventory = inventoryRepository.findByBookId(request.getBookId()).orElseThrow(BookNotFoundException::new);
        inventory.setQuantity(request.getQuantity());
        inventoryRepository.save(inventory);
    }

    @Override
    public void addBookInInventory(InventoryRequestDTO request) throws BookEntryAlreadyExistsException {
        if (inventoryRepository.findByBookId(request.getBookId()).isPresent()) {
            throw new BookEntryAlreadyExistsException();
        }
        var inventory = new Inventory(request);
        inventoryRepository.save(inventory);
    }
}

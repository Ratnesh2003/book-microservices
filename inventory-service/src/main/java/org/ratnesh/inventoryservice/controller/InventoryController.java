package org.ratnesh.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ratnesh.inventoryservice.dto.ErrorDTO;
import org.ratnesh.inventoryservice.dto.InventoryRequestDTO;
import org.ratnesh.inventoryservice.exception.BookEntryAlreadyExistsException;
import org.ratnesh.inventoryservice.exception.BookNotFoundException;
import org.ratnesh.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{bookId}/availability")
    public ResponseEntity<?> getAvailability(@PathVariable String bookId) {
        try {
            return ResponseEntity.ok(inventoryService.getAvailability(bookId));
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateAvailability(@RequestBody InventoryRequestDTO inventoryRequest) {
        try {
            inventoryService.updateAvailability(inventoryRequest);
            return ResponseEntity.ok().build();
        } catch (BookNotFoundException e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> addBookInInventory(@RequestBody InventoryRequestDTO inventoryRequest) {
        try {
            inventoryService.addBookInInventory(inventoryRequest);
            return ResponseEntity.ok().build();
        } catch (BookEntryAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage(), HttpStatus.CONFLICT));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

}

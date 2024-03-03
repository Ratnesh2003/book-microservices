package org.ratnesh.inventoryservice.exception;

public class BookEntryAlreadyExistsException extends RuntimeException {
    public BookEntryAlreadyExistsException() {
        super("Book entry already exists");
    }
}

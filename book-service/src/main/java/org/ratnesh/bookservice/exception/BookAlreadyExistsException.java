package org.ratnesh.bookservice.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException() {
        super("Book already exists");
    }
}

package org.ratnesh.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private int status;

    public ErrorDTO(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }
}

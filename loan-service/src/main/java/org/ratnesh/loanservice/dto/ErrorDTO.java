package org.ratnesh.loanservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private int status;

    public ErrorDTO(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }
}

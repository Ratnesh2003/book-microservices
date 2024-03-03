package org.ratnesh.loanservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanResponseDTO {
    private String id;
    private Long userId;
    private String userName;
    private String bookId;
    private boolean isReturned;
    private LocalDateTime issueDateTime;
    private LocalDateTime returnDateTime;
}

package org.ratnesh.loanservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanRequestDTO {
    private Long userId;
    private String userName;
    private String bookId;
}

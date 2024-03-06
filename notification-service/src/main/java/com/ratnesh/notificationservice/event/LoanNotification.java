package com.ratnesh.notificationservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanNotification {
    private EventType eventType;
    private String eventMessage;
    private String loanId;
    private Long userId;
    private String userName;
    private String bookId;
    private boolean isReturned;
    private LocalDateTime issueDateTime;
    private LocalDateTime returnDateTime;
}

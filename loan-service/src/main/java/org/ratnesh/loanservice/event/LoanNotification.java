package org.ratnesh.loanservice.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ratnesh.loanservice.entity.Loan;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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

    public LoanNotification(Loan loan, EventType eventType, String eventMessage) {
        this.eventType = eventType;
        this.eventMessage = eventMessage;
        this.loanId = loan.getId();
        this.userId = loan.getUserId();
        this.userName = loan.getUserName();
        this.bookId = loan.getBookId();
        this.isReturned = loan.isReturned();
        this.issueDateTime = loan.getIssueDateTime();
        this.returnDateTime = loan.getReturnDateTime();
    }
}

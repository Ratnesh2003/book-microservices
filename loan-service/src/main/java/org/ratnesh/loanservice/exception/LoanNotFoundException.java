package org.ratnesh.loanservice.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException() {
        super("Loan was not found");
    }
}

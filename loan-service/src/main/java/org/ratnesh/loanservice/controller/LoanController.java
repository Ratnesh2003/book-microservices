package org.ratnesh.loanservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ratnesh.loanservice.dto.ErrorDTO;
import org.ratnesh.loanservice.dto.LoanRequestDTO;
import org.ratnesh.loanservice.exception.LoanNotFoundException;
import org.ratnesh.loanservice.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
@RequiredArgsConstructor
@Slf4j
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/")
    public ResponseEntity<?> createLoan(@RequestBody LoanRequestDTO loanRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(loanRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> returnLoan(@PathVariable String id) {
        try {
            loanService.returnLoan(id);
            return ResponseEntity.ok().build();
        } catch (LoanNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLoanById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(loanService.getLoanById(id));
        } catch (LoanNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getLoanByUserId(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(loanService.getLoanByUserId(userId));
        } catch (LoanNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllLoans() {
        try {
            return ResponseEntity.ok(loanService.getAllLoans());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}

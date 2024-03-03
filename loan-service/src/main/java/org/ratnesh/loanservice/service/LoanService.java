package org.ratnesh.loanservice.service;

import org.ratnesh.loanservice.dto.LoanRequestDTO;
import org.ratnesh.loanservice.dto.LoanResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {

    String createLoan(LoanRequestDTO request);

    LoanResponseDTO getLoanById(String id);

    void returnLoan(String id);

    List<LoanResponseDTO> getLoanByUserId(String userId);

    List<LoanResponseDTO> getAllLoans();

}

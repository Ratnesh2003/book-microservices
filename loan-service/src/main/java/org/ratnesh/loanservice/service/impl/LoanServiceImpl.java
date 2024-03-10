package org.ratnesh.loanservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.ratnesh.loanservice.dto.InventoryRequestDTO;
import org.ratnesh.loanservice.dto.LoanRequestDTO;
import org.ratnesh.loanservice.dto.LoanResponseDTO;
import org.ratnesh.loanservice.entity.Loan;
import org.ratnesh.loanservice.event.EventType;
import org.ratnesh.loanservice.event.LoanNotification;
import org.ratnesh.loanservice.exception.BookNotAvailableException;
import org.ratnesh.loanservice.exception.LoanNotFoundException;
import org.ratnesh.loanservice.repository.LoanRepository;
import org.ratnesh.loanservice.service.LoanService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String, LoanNotification> kafkaTemplate;

    @Override
    public String createLoan(LoanRequestDTO request) {
        var loan = new Loan(request);
        var bookCount = getBookCount(request.getBookId());
        assert bookCount != null;
        if (bookCount == 0)
            throw new BookNotAvailableException();

        updateBookCount(request.getBookId(), bookCount - 1);

        loan = loanRepository.save(loan);
        kafkaTemplate.send("loan-notification", new LoanNotification(loan, EventType.LOAN_CREATED, "Loan Created"));
        return loan.getId();
    }

    @Override
    public LoanResponseDTO getLoanById(String id) throws LoanNotFoundException {
        var loan = loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
        return loan.toDTO();
    }

    @Override
    public void returnLoan(String id) throws LoanNotFoundException {
        var loan = loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);
        loan.setReturned(true);
        loan.setReturnDateTime(LocalDateTime.now());

        var bookCount = getBookCount(loan.getBookId());
        assert bookCount != null;
        updateBookCount(loan.getBookId(), bookCount + 1);
        loanRepository.save(loan);

        kafkaTemplate.send("loan-notification", new LoanNotification(loan, EventType.LOAN_RETURNED, "Loan Returned"));
    }

    @Override
    public List<LoanResponseDTO> getLoanByUserId(String userId) {
        var loans = loanRepository.findAllByUserId(userId);
        return loans.stream().map(Loan::toDTO).toList();
    }

    @Override
    public List<LoanResponseDTO> getAllLoans() {
        return loanRepository.findAll().stream().map(Loan::toDTO).toList();
    }

    private void updateBookCount(String bookId, Long count) {
        webClientBuilder.build().put()
                .uri("http://inventory-service/api/inventory/")
                .bodyValue(new InventoryRequestDTO(bookId, count))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    private Long getBookCount(String bookId) {
        return webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory/" + bookId + "/availability")
                .retrieve()
                .bodyToMono(Long.class)
                .block();
    }
}

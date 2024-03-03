package org.ratnesh.loanservice.repository;

import org.ratnesh.loanservice.entity.Loan;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface LoanRepository extends CassandraRepository<Loan, String> {
    Optional<Loan> findAllByUserId(String userId);

}

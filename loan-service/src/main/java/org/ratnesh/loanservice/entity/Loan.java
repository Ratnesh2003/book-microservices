package org.ratnesh.loanservice.entity;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.ratnesh.loanservice.dto.LoanRequestDTO;
import org.ratnesh.loanservice.dto.LoanResponseDTO;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("loan")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Loan {
    @PrimaryKey
    @CassandraType(type = CassandraType.Name.UUID)
    private String id;
    private Long userId;
    private String userName;
    private String bookId;
    private boolean isReturned;
    private LocalDateTime issueDateTime;
    private LocalDateTime returnDateTime;
    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public Loan(LoanRequestDTO request) {
        this.id = UUID.randomUUID().toString();
        this.bookId = request.getBookId();
        this.userId = request.getUserId();
        this.userName = request.getUserName();
        this.issueDateTime = LocalDateTime.now();
    }

    public LoanResponseDTO toDTO() {
        return modelMapper.map(this, LoanResponseDTO.class);
    }


}

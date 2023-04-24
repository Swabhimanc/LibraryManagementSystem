package com.example.librarymanagementsystem.DTO.ResponseDto;


import com.example.librarymanagementsystem.enums.TransactionStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {

    private String transactionNo;

    private TransactionStatus transactionStatus;

    private String bookName;
}

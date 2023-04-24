package com.example.librarymanagementsystem.DTO.ResponseDto;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.entity.Transaction;
import com.example.librarymanagementsystem.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CardResponseDto {


    private int id;
    private Date updatedOn;
    Date issueDate;
    private CardStatus cardStatus;
    private String validTill;

}

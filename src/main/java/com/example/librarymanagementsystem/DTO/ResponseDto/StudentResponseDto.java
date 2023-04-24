package com.example.librarymanagementsystem.DTO.ResponseDto;

import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.enums.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentResponseDto {

    private int id;
    private String name;
    private int age;
    private Department department;
    private String mobNo;
    CardResponseDto cardResponseDto;
}

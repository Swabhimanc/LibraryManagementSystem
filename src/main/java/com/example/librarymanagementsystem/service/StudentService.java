package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.exceptions.InvalidIdException;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;

public interface StudentService {


    public String addStudent(StudentRequestDto studentRequestDto);

    public String deleteStudentById(Integer id);


    public String updateStudentById(Integer id, Student student);

    public UpdateStudentMobileResponseDto updateMobNo(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException;

    public Student getStudentById(int id) throws InvalidIdException;


}

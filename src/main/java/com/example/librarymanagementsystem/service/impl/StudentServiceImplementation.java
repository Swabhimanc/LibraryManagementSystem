package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.enums.CardStatus;
import com.example.librarymanagementsystem.exceptions.InvalidIdException;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setValidTill("2024/03/01");
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student added successfully";
    }

    @Override
    public String deleteStudentById(Integer id) throws NullPointerException {
        try {
            studentRepository.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "Student Deleted";
    }

    @Override
    public String updateStudentById(Integer id, Student student)
    {
        if(studentRepository.existsById(id))
        {
            Student existingStudent = studentRepository.getReferenceById(id);
            if(student.getName()!=null)existingStudent.setName(student.getName());

            if(student.getAge()!=0)existingStudent.setAge(student.getAge());

            if(student.getId()!=0)existingStudent.setId(student.getId());

            if(student.getDepartment()!=null)existingStudent.setDepartment(student.getDepartment());

            if(student.getCard()!=null)existingStudent.setCard(student.getCard());

            if(student.getMobNo()!=null)existingStudent.setMobNo(student.getMobNo());

            studentRepository.save(existingStudent);

        }
        return "Student Updated Successful";
    }

    @Override
    public UpdateStudentMobileResponseDto updateMobNo(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException {
        Student student;

        try{
            student = studentRepository.findById(updateStudentMobileRequestDto.getId()).get();
            student.setMobNo(updateStudentMobileRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            UpdateStudentMobileResponseDto updateStudentMobileResponseDto = new UpdateStudentMobileResponseDto();
            updateStudentMobileResponseDto.setName(updatedStudent.getName());
            updateStudentMobileResponseDto.setMobNo(updatedStudent.getMobNo());

            return updateStudentMobileResponseDto;
        }
        catch (Exception e)
        {
            throw new StudentNotFoundException("Invalid Student Id");
        }

    }

    @Override
    public Student getStudentById(int id) throws InvalidIdException {
        Student student;

        try{
            student = studentRepository.findById(id).get();
            return student;
        }
        catch (Exception e)
        {
            throw new InvalidIdException("Invalid Student Id");
        }
    }

}

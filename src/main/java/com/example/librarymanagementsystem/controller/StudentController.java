package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.exceptions.InvalidIdException;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService.addStudent(studentRequestDto);
    }

    //delete student by ID
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Integer id)
    {
        return studentService.deleteStudentById(id);
    }

    @PostMapping("/update/{id}")
    public String updateStudentById(@PathVariable Integer id, @RequestBody Student student)
    {
        System.out.println(id);
        System.out.println(student.getAge());
        return studentService.updateStudentById(id,student);
    }

    @PutMapping("/update_mobile")
    public UpdateStudentMobileResponseDto updateMobileNo(@RequestBody UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobileRequestDto);
    }

    //delete a student by id

    //update a student by id

    //find a student by id
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("id")int id) throws InvalidIdException {
        return studentService.getStudentById(id);
    }

    //find all student by id

}

package com.example.University.Management.controllers;


import com.example.University.Management.Dto.StudentDto;
import com.example.University.Management.Dto.SubmissionsDto;
import com.example.University.Management.Repo.StudentRepo;
import com.example.University.Management.Service.Imp.Student_imp;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private Student_imp serviceImp;

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto request){

        return new ResponseEntity<>(serviceImp.CreateStudent(request), HttpStatus.CREATED);
    }



}

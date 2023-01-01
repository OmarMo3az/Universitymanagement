package com.example.University.Management.controllers;


import com.example.University.Management.Dto.CoursesDto;
import com.example.University.Management.Dto.StudentDto;
import com.example.University.Management.Service.Imp.Course_imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private Course_imp courseImp;

    @PostMapping("/addCourse/{teacherId}")
    public ResponseEntity<?> addCourse(@RequestBody CoursesDto request, @PathVariable Long teacherId){

        return new ResponseEntity<>(courseImp.CreateCourse(request,teacherId), HttpStatus.CREATED);
    }
}

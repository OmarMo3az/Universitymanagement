package com.example.University.Management.controllers;


import com.example.University.Management.Dto.StudentDto;
import com.example.University.Management.Dto.TeacherDto;
import com.example.University.Management.Repo.TeacherRepo;
import com.example.University.Management.Service.Imp.Student_imp;
import com.example.University.Management.Service.Imp.Teacher_imp;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeacherController {



    @Autowired
    private Teacher_imp serviceImp;

    @Autowired
    private TeacherRepo teacherRepo;


    @PostMapping("/addTeacher")
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDto request){

        return new ResponseEntity<>(serviceImp.Createteacher(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public void delete(@PathVariable Long id){
       teacherRepo.deleteById(id);

        System.out.println("deleted");
    }
}

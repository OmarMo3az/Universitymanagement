package com.example.University.Management.controllers;


import com.example.University.Management.Dto.AssignmentDto;
import com.example.University.Management.Dto.ClassRoomDto;
import com.example.University.Management.Repo.AssignmentRepo;
import com.example.University.Management.Service.Imp.Assignment_imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AssignmentController {

    @Autowired
    private Assignment_imp assignmentImp;

    @Autowired
    private AssignmentRepo assignmentRepo;

    @PostMapping("/addAssignment/{teacherId}")
    public ResponseEntity<?> addAssignment(@RequestBody @Valid AssignmentDto request, @PathVariable Long teacherId){

        return new ResponseEntity<>(assignmentImp.CreateAssignment(request,teacherId), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAssignment/{id}")
    public void delete(@PathVariable Long id){
        assignmentRepo.deleteById(id);

        System.out.println("deleted");
    }
}

package com.example.University.Management.controllers;


import com.example.University.Management.Dto.ClassRoomDto;
import com.example.University.Management.Dto.TeacherDto;
import com.example.University.Management.Repo.ClassRoomRepo;
import com.example.University.Management.Service.Imp.ClassRoom_Imp;
import com.example.University.Management.Service.Imp.Teacher_imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClassRoomController {


    @Autowired
    private ClassRoom_Imp serviceImp;

    @Autowired
    private ClassRoomRepo classRoomRepo;

//@Valid
    @PostMapping("/addClassRoom/teacherId/{teacherId}/courseId/{courseId}")
    public ResponseEntity<?> addClassRoom(@RequestBody @Valid ClassRoomDto request,
                                          @PathVariable Long  teacherId,
                                          @PathVariable Long courseId){

        return new ResponseEntity<>(serviceImp.CreateClassRoom(request,teacherId,courseId),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteClassRoom/{id}")
    public void delete(@PathVariable Long id){
        classRoomRepo.deleteById(id);
        System.out.println("deleted");
    }
}

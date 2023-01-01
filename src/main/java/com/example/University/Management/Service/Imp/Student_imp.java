package com.example.University.Management.Service.Imp;

import com.example.University.Management.Dto.StudentDto;
import com.example.University.Management.Dto.SubmissionsDto;
import com.example.University.Management.Repo.AssignmentRepo;
import com.example.University.Management.Repo.StudentRepo;
import com.example.University.Management.Repo.SubmissionsRepo;
import com.example.University.Management.Service.Student_Service;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.Assignment;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Submissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class Student_imp implements Student_Service {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubmissionsRepo submissionsRepo;
    @Autowired
    private AssignmentRepo assignmentRepo;

    @Override
    public Student CreateStudent(StudentDto requestDto) {

        Student newStudent = new Student();

        newStudent.setName(requestDto.getName());


        studentRepo.save(newStudent);

        return newStudent;
    }


}

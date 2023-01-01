package com.example.University.Management.Service.Imp;

import com.example.University.Management.Dto.TeacherDto;
import com.example.University.Management.Repo.TeacherRepo;
import com.example.University.Management.Service.Teacher_Service;
import com.example.University.Management.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Teacher_imp implements Teacher_Service {


    @Autowired
    private TeacherRepo teacherRepo;
    @Override
    public Teacher Createteacher(TeacherDto requestDto) {

        Teacher newTeacher= new Teacher();

        newTeacher.setName(requestDto.getName());

        teacherRepo.save(newTeacher);

        return newTeacher;

    }
}

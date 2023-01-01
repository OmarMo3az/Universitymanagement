package com.example.University.Management.Service;

import com.example.University.Management.Dto.StudentDto;
import com.example.University.Management.Dto.TeacherDto;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Teacher;

public interface Teacher_Service {

    Teacher Createteacher(TeacherDto requestDto);
}

package com.example.University.Management.Service;

import com.example.University.Management.Dto.CoursesDto;
import com.example.University.Management.model.Courses;

public interface Course_Service {

    Courses CreateCourse(CoursesDto requestDto,Long id);
}

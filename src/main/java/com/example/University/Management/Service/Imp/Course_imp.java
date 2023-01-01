package com.example.University.Management.Service.Imp;

import com.example.University.Management.Dto.CoursesDto;
import com.example.University.Management.Dto.StudentDto;
import com.example.University.Management.Repo.AssignmentRepo;
import com.example.University.Management.Repo.CourseRepo;
import com.example.University.Management.Repo.StudentRepo;
import com.example.University.Management.Repo.TeacherRepo;
import com.example.University.Management.Service.Course_Service;
import com.example.University.Management.Service.Student_Service;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.Assignment;
import com.example.University.Management.model.Courses;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class Course_imp implements Course_Service {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Courses CreateCourse(CoursesDto requestDto,Long teacherId) {

        Teacher teacher = teacherRepo.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", teacherId));

        Courses newCourse = new Courses();
        newCourse.setCourse_name(requestDto.getCourse_name());
        for (Assignment assignment : requestDto.getAssignments()) {
            assignment.setTeacherName(teacher.getName());
            newCourse.addAssignments(assignment);
        }
        teacher.addCourse(newCourse);
        teacherRepo.save(teacher);
        return newCourse;
    }
}

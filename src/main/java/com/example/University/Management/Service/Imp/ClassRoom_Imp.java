package com.example.University.Management.Service.Imp;

import com.example.University.Management.Dto.ClassRoomDto;
import com.example.University.Management.Repo.ClassRoomRepo;
import com.example.University.Management.Repo.CourseRepo;
import com.example.University.Management.Repo.TeacherRepo;
import com.example.University.Management.Service.ClassRoom_Service;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.ClassRoom;
import com.example.University.Management.model.Courses;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class ClassRoom_Imp implements ClassRoom_Service {

    @Autowired
    private ClassRoomRepo classRoomRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public ClassRoom CreateClassRoom(ClassRoomDto requestDto , Long teacherId , Long courseId) {
        Teacher teacher = teacherRepo.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", teacherId));

        Courses course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", courseId));

        ClassRoom newClassRoom = new ClassRoom();

        newClassRoom.setName(requestDto.getName());
        newClassRoom.setDay(requestDto.getDay());
        newClassRoom.setTime_start(requestDto.getTime_start());
        newClassRoom.setTime_end(requestDto.getTime_end());

        for (Student student : requestDto.getStudents()) {
            newClassRoom.addStudent(student);
        }

        newClassRoom.addCourse(course);
        teacher.addClassRoom(newClassRoom);
        teacherRepo.save(teacher);

     //   ClassRoom savedClassRoom =   classRoomRepo.save(newClassRoom);
        return newClassRoom;
    }
}

// "teacher": {
//        "id": 6,
//        "name": " moaz"
//    },
// "courses": [
//         {
//         "id": 7,
//         "course_name": "information Data",
//         "assignments": [
//         {
//         "id": 39,
//         "submissions": [],
//         "question": "first task",
//         "state": "pending",
//         "teacherName": " moaz"
//         },
//         {
//         "id": 38,
//         "submissions": [],
//         "question": " task 2",
//         "state": "pending",
//         "teacherName": " moaz"
//         }
//         ]
//         }
//         ],
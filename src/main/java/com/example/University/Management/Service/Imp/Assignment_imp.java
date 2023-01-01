package com.example.University.Management.Service.Imp;


import com.example.University.Management.Dto.AssignmentDto;
import com.example.University.Management.Repo.AssignmentRepo;
import com.example.University.Management.Repo.TeacherRepo;
import com.example.University.Management.Service.Assignment_Service;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.Assignment;
import com.example.University.Management.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Assignment_imp implements Assignment_Service {

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Assignment CreateAssignment(AssignmentDto requestDto, Long id) {

        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", id));

        Assignment newAssignment = new Assignment();

        newAssignment.setTeacherName(teacher.getName());
       // newAssignment.setCourse(requestDto.getCourse());
        newAssignment.setQuestion(requestDto.getQuestion());
        newAssignment.setState(requestDto.getState());

        Assignment savedAssignment = assignmentRepo.save(newAssignment);

        return newAssignment;
    }
}

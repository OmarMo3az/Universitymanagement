package com.example.University.Management.Dto;

import com.example.University.Management.model.Courses;
import com.example.University.Management.model.Submissions;
import com.example.University.Management.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDto {




    private Courses course;


    private Set<Submissions> submissions ;

//    private Set<Task> tasks ;


    private String  state;

    private String teacherName;

    private String question;
}

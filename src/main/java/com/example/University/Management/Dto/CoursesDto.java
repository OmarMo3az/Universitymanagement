package com.example.University.Management.Dto;

import com.example.University.Management.model.Assignment;
import com.example.University.Management.model.ClassRoom;
import com.example.University.Management.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDto {


    private String course_name ;



    private ClassRoom classRoom;

    private Teacher teacher;
    private Set<Assignment> assignments ;

//    private String  state;
//
//    private String question;
}

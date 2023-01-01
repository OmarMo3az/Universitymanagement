package com.example.University.Management.Dto;

import com.example.University.Management.model.Courses;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomDto {



    private String name ;

    private Date day ;

    private String time_start ;

    private String time_end ;

//    private Teacher teacher;

    private Set<Courses> courses ;

//    @Size(min = 10, max =40 )
//    @Size(min = 2, max =40 )
    private Set<Student> students;
}

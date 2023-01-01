package com.example.University.Management.Dto;

import com.example.University.Management.model.ClassRoom;
import com.example.University.Management.model.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private String name ;

    private Set<ClassRoom> classRooms;

    private Set<Courses> courses;
}

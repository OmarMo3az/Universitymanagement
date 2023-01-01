package com.example.University.Management.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAssignmentResponse {

    private int     teacher_id;
    private String course_name;

    private int     student_id;

    private int     assignment_id;
    private int     submission_id;

    private String state;

    private String answer;

}

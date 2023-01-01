package com.example.University.Management.Dto;

import com.example.University.Management.model.Assignment;
import com.example.University.Management.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionsDto {
    private int score ;
    private String comments;
    private String  answer ;
    private String  state ;

}

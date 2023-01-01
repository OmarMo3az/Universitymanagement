package com.example.University.Management.Dto;

import com.example.University.Management.model.Submissions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String name;

    private Submissions submissions;

}

package com.example.University.Management.Dto;

import com.example.University.Management.model.Assignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String question;

    private String answer;


    private Assignment assignment;

}

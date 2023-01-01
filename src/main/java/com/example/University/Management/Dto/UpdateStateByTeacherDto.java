package com.example.University.Management.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStateByTeacherDto {

    private int score ;
    private String comments;
    private String  state ;
}
